package com.example.store.service.impl;

import com.example.store.dto.PCDto;
import com.example.store.mapper.DeviceMapper;
import com.example.store.model.Monitor;
import com.example.store.model.PC;
import com.example.store.model.type.DeviceType;
import com.example.store.repository.DeviceRepository;
import com.example.store.repository.PCRepository;
import com.example.store.service.PCService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class PCServiceImpl implements PCService {
    private final PCRepository pcRepository;


    @Override
    public PCDto addDevice(PCDto dto) {
        if (pcRepository.existsBySerialNumberAndProducer(dto.getSerialNumber(), dto.getProducer())) {
            throw new RuntimeException("Устройство с серийным номером " + dto.getSerialNumber() + " у производителя " + dto.getProducer() + " уже существует!");
        }
        PC pc = DeviceMapper.INSTANCE.toEntity(dto);
        pc.setDeviceType(DeviceType.PC);
        pc = pcRepository.save(pc);
        PCDto pcDto = DeviceMapper.INSTANCE.toDTO(pc);
        pcDto.setId(pc.getId());
        log.info("ПК с серийным номером {} добавлен", pc.getSerialNumber());
        return pcDto;
    }

    @Override
    public PCDto updateDevice(PCDto dto) {
        PC pc = pcRepository.findById(dto.getId()).orElseThrow(() -> new NotFoundException("Устройство с идентификатором " + dto.getId() + " не найдено"));
        if (dto.getPrice() == 0) {
            throw new RuntimeException("Стоимость товара не может равняться 0");
        }
        pc.setPcFormFactor(dto.getPcFormFactor());
        pc.setPrice(dto.getPrice());
        pc.setQuantity(dto.getQuantity());
        pc.setProducer(dto.getProducer());
        pc.setSerialNumber(dto.getSerialNumber());
        pcRepository.save(pc);
        log.info("Компьютер с серийным номером {} обновлен", pc.getSerialNumber());
        return DeviceMapper.INSTANCE.toDTO(pc);
    }

}
