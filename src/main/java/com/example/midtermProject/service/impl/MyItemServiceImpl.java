package com.example.midtermProject.service.impl;

import com.example.midtermProject.entity.MyItemEntity;
import com.example.midtermProject.repository.MyItemRepo;
import com.example.midtermProject.service.MyItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyItemServiceImpl implements MyItemService {

    private final MyItemRepo myBookRepo;
    public MyItemServiceImpl(MyItemRepo myBookRepo){
        this.myBookRepo = myBookRepo;
    }
    @Override
    public void save(MyItemEntity myBook) {
        myBookRepo.save(myBook);
    }

    @Override
    public MyItemEntity getBookById(int id) {
        return myBookRepo.findById(id).get();
    }

    @Override
    public List<MyItemEntity> getAllBooks() {
       return myBookRepo.findAll();
    }
    @Override
    public void deleteById(int id){
        myBookRepo.deleteById(id);
    }
}
