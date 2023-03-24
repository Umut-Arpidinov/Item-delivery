package com.example.midtermProject.controller;

import com.example.midtermProject.service.MyBookService;
import com.example.midtermProject.service.impl.MyBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyBookListController {

    private MyBookServiceImpl service;
    public MyBookListController(MyBookServiceImpl service){
        this.service = service;
    }
    @RequestMapping("/deleteMyList/{id}")
    public String deleteMyBook(@PathVariable("id") int id){
        service.deleteById(id);
        return "redirect:/my_books";
    }

}
