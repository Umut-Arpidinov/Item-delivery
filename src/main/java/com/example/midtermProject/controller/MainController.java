package com.example.midtermProject.controller;

import com.example.midtermProject.entity.BookEntity;
import com.example.midtermProject.service.impl.BookServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {

    private final BookServiceImpl service;

    public MainController(BookServiceImpl service){
        this.service = service;
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
    public String getMyBooks(){
        return "myBooks";
    }

    @PostMapping("/save")
    public String addNewBook(@ModelAttribute BookEntity book){
        service.save(book);
        return "redirect:/all_books";
    }

}
