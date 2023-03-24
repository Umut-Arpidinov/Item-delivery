package com.example.midtermProject.controller;

import com.example.midtermProject.entity.BookEntity;
import com.example.midtermProject.entity.MyBookEntity;
import com.example.midtermProject.service.impl.BookServiceImpl;
import com.example.midtermProject.service.impl.MyBookServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    private final BookServiceImpl service;
    private final MyBookServiceImpl myBookService;

    public MainController(BookServiceImpl service, MyBookServiceImpl myBookService){

        this.service = service;
        this.myBookService = myBookService;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/book_register")
    public String bookRegister(){
        return "newBook";
    }

    @GetMapping("/all_books")
    public ModelAndView getAllBooks(){
        List<BookEntity> list = service.getAllBooks();
        ModelAndView m = new ModelAndView();
        m.setViewName("allBooks");
        m.addObject("books",list);
        return new ModelAndView("allBooks","book",list);

    }
    @GetMapping("/my_books")
    public String getMyBooks(Model model){
        List<MyBookEntity> list = myBookService.getAllBooks();
        model.addAttribute("book",list);
        return "myBooks";
    }

    @PostMapping("/save")
    public String addNewBook(@ModelAttribute BookEntity book){
        service.save(book);
        return "redirect:/all_books";
    }

    @RequestMapping("/myList/{id}")
    public String getMyList(@PathVariable("id") int id){
        BookEntity b = service.getBookById(id);
        MyBookEntity mb = new MyBookEntity(b.getId(),b.getName(),b.getAuthor(),b.getAvailability());
        myBookService.save(mb);
        return "redirect:/my_books";
    }
    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id,Model model){
        BookEntity book = service.getBookById(id);
        model.addAttribute("book",book);
        return "editBook";
    }
    @RequestMapping("/deleteBook/{id}")
    public String deleteBookById(@PathVariable("id") int id){
        service.deleteById(id);
        return "redirect:/all_books";
    }



}
