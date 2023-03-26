package com.example.midtermProject.controller;

import com.example.midtermProject.service.impl.MyItemServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyBookListController {

    private final MyItemServiceImpl service;
    public MyBookListController(MyItemServiceImpl service){
        this.service = service;
    }
    @RequestMapping("/deleteMyList/{id}")
    public String deleteMyBook(@PathVariable("id") int id){
        service.deleteById(id);
        return "redirect:/my_items";
    }

}
