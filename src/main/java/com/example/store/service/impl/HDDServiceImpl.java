package com.example.store.service.impl;

import com.example.store.dto.DeviceDTO;
import com.example.store.dto.HDDDto;
import com.example.store.mapper.DeviceMapper;
import com.example.store.model.Device;
import com.example.store.model.HDD;
import com.example.store.model.type.DeviceType;
import com.example.store.repository.DeviceRepository;
import com.example.store.repository.HDDRepository;
import com.example.store.service.HDDService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class HDDServiceImpl implements HDDService {
    private final HDDRepository hddRepository;


    @Override
    public HDDDto addDevice(HDDDto dto) {
        if (hddRepository.existsBySerialNumberAndProducer(dto.getSerialNumber(), dto.getProducer())) {
            throw new RuntimeException("Устройство с серийным номером " + dto.getSerialNumber() + " у производителя " + dto.getProducer() + " уже существует!");
        }
        HDD hdd = DeviceMapper.INSTANCE.toEntity(dto);
        hdd.setDeviceType(DeviceType.HDD);
        hdd = hddRepository.save(hdd);
        HDDDto hddDto = DeviceMapper.INSTANCE.toDTO(hdd);
        hddDto.setId(hdd.getId());
        log.info("Жесткий диск с серийным номером {} добавлен", hdd.getSerialNumber());
        return hddDto;
    }

    @Override
    public HDDDto updateDevice(HDDDto dto) {
        HDD hdd = hddRepository.findById(dto.getId()).orElseThrow(() -> new NotFoundException("Устройство с идентификатором " + dto.getId() + " не найдено"));
        if (dto.getPrice() == 0) {
            throw new RuntimeException("Стоимость товара не может равняться 0");
        }
        hdd.setHddCapacity(dto.getHddCapacity());
        hdd.setPrice(dto.getPrice());
        hdd.setQuantity(dto.getQuantity());
        hdd.setProducer(dto.getProducer());
        hdd.setSerialNumber(dto.getSerialNumber());
        hddRepository.save(hdd);
        log.info("Жесткий диск с серийным номером {} обновлен", hdd.getSerialNumber());
        return DeviceMapper.INSTANCE.toDTO(hdd);
    }


}
