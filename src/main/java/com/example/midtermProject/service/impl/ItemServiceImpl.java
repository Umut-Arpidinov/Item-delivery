package com.example.midtermProject.service.impl;
import com.example.midtermProject.entity.ItemEntity;
import com.example.midtermProject.repository.ItemRepo;
import com.example.midtermProject.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepo itemRepo;


    public ItemServiceImpl(ItemRepo itemRepo){
        this.itemRepo = itemRepo;
    }

    @Override
    public void save(ItemEntity itemEntity) {
        itemRepo.save(itemEntity);
    }

    @Override
    public List<ItemEntity> getAllBooks() {
        return itemRepo.findAll();
    }

    @Override
    public ItemEntity getBookById(int id) {
        return itemRepo.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        itemRepo.deleteById(id);
    }
}
