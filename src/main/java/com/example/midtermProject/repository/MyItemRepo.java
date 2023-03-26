package com.example.midtermProject.repository;

import com.example.midtermProject.entity.MyItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyItemRepo extends JpaRepository<MyItemEntity,Integer> {

}
