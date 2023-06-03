package com.example.store.repository;

import com.example.store.model.Device;
import com.example.store.model.HDD;
import com.example.store.model.type.DeviceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface HDDRepository extends JpaRepository<HDD, Integer> {
    boolean existsBySerialNumberAndProducer(String serialNumber, String producer);

}
