package com.example.store.repository;

import com.example.store.model.HDD;
import com.example.store.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository<Laptop, Integer> {
    boolean existsBySerialNumberAndProducer(String serialNumber, String producer);

}
