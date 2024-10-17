package com.example.nuevaeps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.nuevaeps.model.FileDB;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, Integer> {

}
