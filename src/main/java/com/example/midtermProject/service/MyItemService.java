package com.example.midtermProject.service;

import com.example.midtermProject.entity.MyItemEntity;

import java.util.List;

public interface MyItemService {
    public void save(MyItemEntity item);
    public MyItemEntity getItemById(int id);
    public List<MyItemEntity> getAllItems();
    public void deleteById(int id);

}
