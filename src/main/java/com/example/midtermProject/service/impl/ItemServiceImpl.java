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
    public void save(ItemEntity item) {
        itemRepo.save(item);
    }

    @Override
    public List<ItemEntity> getAllItems() {
        return itemRepo.findAll();
    }

    @Override
    public ItemEntity getItemById(int id) {
        return itemRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        itemRepo.deleteById(id);
    }
}
