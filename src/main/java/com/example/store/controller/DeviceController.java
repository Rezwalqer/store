package com.example.store.controller;

import com.example.store.dto.DeviceDTO;
import com.example.store.model.type.DeviceType;
import com.example.store.service.impl.DeviceServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/devices")
@Tag(name = "Поиск товара")
public class DeviceController {
    private final DeviceServiceImpl deviceServicesImpl;

    @Operation(summary = "Получить список всех устройств определенного типа")
    @GetMapping()
    public ResponseEntity<Collection<DeviceDTO>> getAllDevices(@Valid DeviceType deviceType) {
        return ResponseEntity.ok(deviceServicesImpl.getDevices(deviceType));
    }

    @Operation(summary = "Получить информацию о товаре по id")
    @GetMapping("/{id}")
    public ResponseEntity<DeviceDTO> getDeviceInfo(@Valid @PathVariable Integer id) {
        return ResponseEntity.ok(deviceServicesImpl.findById(id));
    }


}
