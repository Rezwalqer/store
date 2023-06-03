package com.example.store.repository;

import com.example.store.dto.DeviceDTO;
import com.example.store.model.Device;
import com.example.store.model.type.DeviceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface DeviceRepository extends JpaRepository<Device, Integer> {
    boolean existsById(Integer id);

    Collection<Device> findAllByDeviceType(DeviceType deviceType);

}
