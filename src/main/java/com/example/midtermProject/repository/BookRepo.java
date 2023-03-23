package com.example.midtermProject.repository;

import com.example.midtermProject.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<BookEntity,Integer> {
}
