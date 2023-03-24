package com.example.midtermProject.service.impl;
import com.example.midtermProject.entity.BookEntity;
import com.example.midtermProject.repository.BookRepo;
import com.example.midtermProject.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl  implements BookService {
    private final BookRepo bookRepo;


    public BookServiceImpl(BookRepo bookRepo){
        this.bookRepo = bookRepo;
    }

    @Override
    public void save(BookEntity bookEntity) {
        bookRepo.save(bookEntity);
    }

    @Override
    public List<BookEntity> getAllBooks() {
        return bookRepo.findAll();
    }

    @Override
    public BookEntity getBookById(int id) {
        return bookRepo.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        bookRepo.deleteById(id);
    }
}
