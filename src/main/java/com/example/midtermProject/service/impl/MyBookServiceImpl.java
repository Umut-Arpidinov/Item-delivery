package com.example.midtermProject.service.impl;

import com.example.midtermProject.entity.MyBookEntity;
import com.example.midtermProject.repository.MyBookRepository;
import com.example.midtermProject.service.MyBookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookServiceImpl implements MyBookService {

    private final MyBookRepository myBookRepo;
    public MyBookServiceImpl( MyBookRepository  myBookRepo){
        this.myBookRepo = myBookRepo;
    }
    @Override
    public void save(MyBookEntity myBook) {
        myBookRepo.save(myBook);
    }

    @Override
    public MyBookEntity getBookById(int id) {
        return myBookRepo.findById(id).get();
    }

    @Override
    public List<MyBookEntity> getAllBooks() {
       return myBookRepo.findAll();
    }
    @Override
    public void deleteById(int id){
        myBookRepo.deleteById(id);
    }
}
