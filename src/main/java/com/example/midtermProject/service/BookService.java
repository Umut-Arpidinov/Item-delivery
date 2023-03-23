package com.example.midtermProject.service;


import com.example.midtermProject.entity.BookEntity;

import java.util.List;

public interface BookService {
    void save(BookEntity bookEntity);
    List<BookEntity> getAllBooks();

}
