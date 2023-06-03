package com.example.store.repository;

import com.example.store.model.Laptop;
import com.example.store.model.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitorRepository extends JpaRepository<Monitor, Integer> {
    boolean existsBySerialNumberAndProducer(String serialNumber, String producer);

}
