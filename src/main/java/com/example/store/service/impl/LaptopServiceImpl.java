package com.example.store.service.impl;

import com.example.store.dto.LaptopDTO;
import com.example.store.mapper.DeviceMapper;
import com.example.store.model.HDD;
import com.example.store.model.Laptop;
import com.example.store.model.type.DeviceType;
import com.example.store.repository.DeviceRepository;
import com.example.store.repository.LaptopRepository;
import com.example.store.service.LaptopService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class LaptopServiceImpl implements LaptopService {
    private final LaptopRepository laptopRepository;

    @Override
    public LaptopDTO addDevice(LaptopDTO dto) {
        if (laptopRepository.existsBySerialNumberAndProducer(dto.getSerialNumber(), dto.getProducer())) {
            throw new RuntimeException("Устройство с серийным номером " + dto.getSerialNumber() + " у производителя " + dto.getProducer() + " уже существует!");
        }
        Laptop laptop = DeviceMapper.INSTANCE.toEntity(dto);
        laptop.setDeviceType(DeviceType.LAPTOP);
        laptop = laptopRepository.save(laptop);
        LaptopDTO laptopDTO = DeviceMapper.INSTANCE.toDTO(laptop);
        laptopDTO.setId(laptop.getId());
        log.info("Ноутбук с серийным номером {} добавлен", laptop.getSerialNumber());
        return laptopDTO;
    }

    @Override
    public LaptopDTO updateDevice(LaptopDTO dto) {
        Laptop laptop = laptopRepository.findById(dto.getId()).orElseThrow(() -> new NotFoundException("Устройство с идентификатором " + dto.getId() + " не найдено"));
        if (dto.getPrice() == 0) {
            throw new RuntimeException("Стоимость товара не может равняться 0");
        }
        laptop.setLaptopSize(dto.getLaptopSize());
        laptop.setPrice(dto.getPrice());
        laptop.setQuantity(dto.getQuantity());
        laptop.setProducer(dto.getProducer());
        laptop.setSerialNumber(dto.getSerialNumber());
        laptopRepository.save(laptop);
        log.info("Ноутбук с серийным номером {} обновлен", laptop.getSerialNumber());
        return DeviceMapper.INSTANCE.toDTO(laptop);
    }

}
