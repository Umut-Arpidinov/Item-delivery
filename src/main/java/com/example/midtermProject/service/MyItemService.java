package com.example.midtermProject.service;

import com.example.midtermProject.entity.MyItemEntity;

import java.util.List;

public interface MyItemService {
    public void save(MyItemEntity myBook);
    public MyItemEntity getBookById(int id);
    public List<MyItemEntity> getAllBooks();
    public void deleteById(int id);

}
