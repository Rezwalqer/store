package com.example.store.controller;

import com.example.store.dto.LaptopDTO;
import com.example.store.dto.MonitorDTO;
import com.example.store.service.impl.LaptopServiceImpl;
import com.example.store.service.impl.MonitorServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/laptop")
@Tag(name = "Ноутбуки")
public class LaptopController {
    private final LaptopServiceImpl laptopServiceImpl;

    @Operation(summary = "Добавить новый ноутбук")
    @PostMapping()
    public ResponseEntity<LaptopDTO> addDevice(@Valid @RequestBody LaptopDTO dto) {
        return ResponseEntity.ok(laptopServiceImpl.addDevice(dto));
    }

    @Operation(summary = "Обновить информацию о ноутбуке")
    @PatchMapping()
    public ResponseEntity<LaptopDTO> updateDevice(@Valid @RequestBody LaptopDTO dto) {
        return ResponseEntity.ok(laptopServiceImpl.updateDevice(dto));
    }

}
