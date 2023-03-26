package com.example.midtermProject.service;


import com.example.midtermProject.entity.ItemEntity;

import java.util.List;

public interface ItemService {
    void save(ItemEntity item);
    List<ItemEntity>getAllItems();
    ItemEntity getItemById(int id);
    void deleteById(int id);
}
