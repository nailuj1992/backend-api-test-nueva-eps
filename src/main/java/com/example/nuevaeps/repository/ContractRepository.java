package com.example.nuevaeps.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.nuevaeps.model.Contract;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {

	Page<Contract> findAll(Pageable pageable);

}
