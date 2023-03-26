package com.example.midtermProject.repository;

import com.example.midtermProject.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<ItemEntity,Integer> {
}
