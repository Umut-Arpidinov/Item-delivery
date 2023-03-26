package com.example.midtermProject.service.impl;

import com.example.midtermProject.entity.MyItemEntity;
import com.example.midtermProject.repository.MyItemRepo;
import com.example.midtermProject.service.MyItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyItemServiceImpl implements MyItemService {

    private final MyItemRepo myItemRepo;
    public MyItemServiceImpl(MyItemRepo myItemRepo){
        this.myItemRepo = myItemRepo;
    }
    @Override
    public void save(MyItemEntity myBook) {
        myItemRepo.save(myBook);
    }

    @Override
    public MyItemEntity getItemById(int id) {
        return myItemRepo.findById(id).get();
    }

    @Override
    public List<MyItemEntity> getAllItems() {
       return myItemRepo.findAll();
    }
    @Override
    public void deleteById(int id){
        myItemRepo.deleteById(id);
    }
}
