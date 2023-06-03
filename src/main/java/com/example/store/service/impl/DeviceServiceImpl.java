package com.example.store.service.impl;

import com.example.store.dto.DeviceDTO;
import com.example.store.mapper.DeviceMapper;
import com.example.store.model.type.DeviceType;
import com.example.store.repository.DeviceRepository;
import com.example.store.service.DeviceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class DeviceServiceImpl implements DeviceService {
    private final DeviceRepository deviceRepository;

    @Override
    @Transactional(readOnly = true)
    public Collection<DeviceDTO> getDevices(DeviceType deviceType) {
        return deviceRepository.findAllByDeviceType(deviceType).stream().map(DeviceMapper.INSTANCE:: toDeviceDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public DeviceDTO findById(Integer id) {
        return DeviceMapper.INSTANCE.toDeviceDTO(deviceRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Устройство с идентификатором " + id + " не найдено")));
    }
}
