package com.example.midtermProject.controller;

import com.example.midtermProject.entity.BookEntity;
import com.example.midtermProject.entity.MyBookEntity;
import com.example.midtermProject.service.impl.BookServiceImpl;
import com.example.midtermProject.service.impl.MyBookServiceImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
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
    public String bookRegister(Model model){
        model.addAttribute("book", new BookEntity());
        return "newBook";
    }

    @PostMapping("/save")
    public String addNewBook(@Valid @ModelAttribute("book") BookEntity book, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "newBook";
        }
        service.save(book);
        return "redirect:/all_books";
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


    @RequestMapping("/myList/{id}")
    public String getMyList(@PathVariable("id") int id){
        BookEntity b = service.getBookById(id);
        MyBookEntity mb = new MyBookEntity(b.getId(),b.getName(),b.getAuthor(),b.getAvailability());
        myBookService.save(mb);
        return "redirect:/my_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
        BookEntity book = service.getBookById(id);
        model.addAttribute("book", book);
        return "editBook";
    }

    @PostMapping("/editBook/{id}")
    public String updateBook(@PathVariable("id") int id, @Valid @ModelAttribute("book") BookEntity book,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "editBook";
        } else {
            BookEntity existingBook = service.getBookById(id);
            existingBook.setName(book.getName());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setAvailability(book.getAvailability());
            service.save(existingBook);
            return "redirect:/all_books";
        }
    }


    @RequestMapping("/deleteBook/{id}")
    public String deleteBookById(@PathVariable("id") int id){
        service.deleteById(id);
        return "redirect:/all_books";
    }



}
