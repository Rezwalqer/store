package com.example.store.repository;

import com.example.store.model.Monitor;
import com.example.store.model.PC;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PCRepository extends JpaRepository<PC, Integer> {
    boolean existsBySerialNumberAndProducer(String serialNumber, String producer);

}
