package com.example.store.service;

import com.example.store.dto.DeviceDTO;
import com.example.store.dto.HDDDto;
import com.example.store.model.type.DeviceType;

import java.util.Collection;

public interface DeviceService {
    Collection<DeviceDTO> getDevices(DeviceType deviceType);

    DeviceDTO findById(Integer id);

}
