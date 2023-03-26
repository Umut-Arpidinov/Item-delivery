package com.example.midtermProject.service;


import com.example.midtermProject.entity.ItemEntity;

import java.util.List;

public interface ItemService {
    void save(ItemEntity itemEntity);
    List<ItemEntity>getAllBooks();
    ItemEntity getBookById(int id);
    void deleteById(int id);
}
