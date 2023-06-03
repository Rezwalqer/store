package com.example.store.service;

import com.example.store.dto.MonitorDTO;

import java.util.Collection;

public interface MonitorService {
    MonitorDTO addDevice(MonitorDTO dto);

    MonitorDTO updateDevice(MonitorDTO dto);

}
