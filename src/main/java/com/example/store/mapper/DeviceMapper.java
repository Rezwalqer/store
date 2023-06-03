package com.example.store.mapper;

import com.example.store.dto.*;
import com.example.store.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeviceMapper {
    DeviceMapper INSTANCE = Mappers.getMapper(DeviceMapper.class);

    HDDDto toDTO(HDD hdd);

    HDD toEntity(HDDDto dto);

    LaptopDTO toDTO(Laptop laptop);

    Laptop toEntity(LaptopDTO laptopDTO);

    MonitorDTO toDTO(Monitor monitor);

    Monitor toEntity(MonitorDTO dto);

    PCDto toDTO(PC pc);

    PC toEntity(PCDto dto);

    DeviceDTO toDeviceDTO(Device device);

}
