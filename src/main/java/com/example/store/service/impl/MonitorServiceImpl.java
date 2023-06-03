package com.example.store.service.impl;

import com.example.store.dto.MonitorDTO;
import com.example.store.mapper.DeviceMapper;
import com.example.store.model.Laptop;
import com.example.store.model.Monitor;
import com.example.store.model.type.DeviceType;
import com.example.store.repository.DeviceRepository;
import com.example.store.repository.MonitorRepository;
import com.example.store.service.MonitorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class MonitorServiceImpl implements MonitorService {
    private final MonitorRepository monitorRepository;

    @Override
    public MonitorDTO addDevice(MonitorDTO dto) {
        if (monitorRepository.existsBySerialNumberAndProducer(dto.getSerialNumber(), dto.getProducer())) {
            throw new RuntimeException("Устройство с серийным номером " + dto.getSerialNumber() + " у производителя " + dto.getProducer() + " уже существует!");
        }
        Monitor monitor = DeviceMapper.INSTANCE.toEntity(dto);
        monitor.setDeviceType(DeviceType.MONITOR);
        monitor = monitorRepository.save(monitor);
        MonitorDTO monitorDTO = DeviceMapper.INSTANCE.toDTO(monitor);
        monitorDTO.setId(monitor.getId());
        log.info("Монитор с серийным номером {} добавлен", monitor.getSerialNumber());
        return monitorDTO;
    }

    @Override
    public MonitorDTO updateDevice(MonitorDTO dto) {
        Monitor monitor = monitorRepository.findById(dto.getId()).orElseThrow(() -> new NotFoundException("Устройство с идентификатором " + dto.getId() + " не найдено"));
        if (dto.getPrice() == 0) {
            throw new RuntimeException("Стоимость товара не может равняться 0");
        }
        monitor.setMonitorSize(dto.getMonitorSize());
        monitor.setPrice(dto.getPrice());
        monitor.setQuantity(dto.getQuantity());
        monitor.setProducer(dto.getProducer());
        monitor.setSerialNumber(dto.getSerialNumber());
        monitorRepository.save(monitor);
        log.info("Монитор с серийным номером {} обновлен", monitor.getSerialNumber());
        return DeviceMapper.INSTANCE.toDTO(monitor);
    }

}
