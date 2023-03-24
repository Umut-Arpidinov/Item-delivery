package com.example.midtermProject.repository;

import com.example.midtermProject.entity.MyBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyBookRepository extends JpaRepository<MyBookEntity,Integer> {

}
