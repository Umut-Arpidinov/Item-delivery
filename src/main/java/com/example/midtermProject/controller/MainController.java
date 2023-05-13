package com.example.midtermProject.controller;

import com.example.midtermProject.entity.ItemEntity;
import com.example.midtermProject.entity.MyItemEntity;
import com.example.midtermProject.service.impl.ItemServiceImpl;
import com.example.midtermProject.service.impl.MyItemServiceImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {

    private final ItemServiceImpl service;
    private final MyItemServiceImpl myItemService;

    public MainController(ItemServiceImpl service, MyItemServiceImpl myBookService){

        this.service = service;
        this.myItemService = myBookService;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/item_register")
    public String ItemRegister(Model model){
        model.addAttribute("item", new ItemEntity());
        return "newItem";
    }

    @PostMapping("/save")
    public String addNewItem(@Valid @ModelAttribute("item") ItemEntity book, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "newItem";
        }
        service.save(book);
        return "redirect:/all_items";
    }

    @GetMapping("/all_items")
    public ModelAndView getAllItems(){
        List<ItemEntity> list = service.getAllItems();
        ModelAndView m = new ModelAndView();
        m.setViewName("allItems");
        m.addObject("items",list);
        return new ModelAndView("allItems","item",list);

    }
    @GetMapping("/my_items")
    public String getMyItems(Model model){
        List<MyItemEntity> list = myItemService.getAllItems();
        model.addAttribute("item",list);
        return "myItems";
    }


    @RequestMapping(value = "/myList/{id}",method=RequestMethod.POST )
    public String getMyList(@PathVariable("id") int id){
        ItemEntity b = service.getItemById(id);
        MyItemEntity mb = new MyItemEntity(b.getId(),b.getItemName(),b.getDescription(),b.getPrice(),b.getCurrency(),b.getType());
        myItemService.save(mb);
        return "redirect:/my_items";
    }

    @RequestMapping("/editItem/{id}")
    public String editItem(@PathVariable("id") int id, Model model) {
        ItemEntity item = service.getItemById(id);
        model.addAttribute("item", item);
        return "editItem";
    }

    @PostMapping("/editItem/{id}")
    public String updateItem(@PathVariable("id") int id, @Valid @ModelAttribute("item") ItemEntity item,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "editItem";
        } else {
            ItemEntity existingItem = service.getItemById(id);
            existingItem.setItemName(item.getItemName());
            existingItem.setDescription(item.getDescription());
            existingItem.setPrice(item.getPrice());
            existingItem.setCurrency(item.getCurrency());
            existingItem.setType(item.getType());
            service.save(existingItem);
            return "redirect:/all_items";
        }
    }


    @RequestMapping("/deleteItem/{id}")
    public String deleteItemById(@PathVariable("id") int id){
        service.deleteById(id);
        return "redirect:/all_items";
    }



}
