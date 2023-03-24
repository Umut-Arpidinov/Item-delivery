package com.example.midtermProject.service;


import com.example.midtermProject.entity.BookEntity;

import java.util.List;
import java.util.Optional;

public interface BookService {
    void save(BookEntity bookEntity);
    List<BookEntity>getAllBooks();
    BookEntity getBookById(int id);
    void deleteById(int id);
}
