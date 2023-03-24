package com.example.midtermProject.service;

import com.example.midtermProject.entity.MyBookEntity;

import java.util.List;

public interface MyBookService {
    public void save(MyBookEntity myBook);
    public MyBookEntity getBookById(int id);
    public List<MyBookEntity> getAllBooks();
    public void deleteById(int id);

}
