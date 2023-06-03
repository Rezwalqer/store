package com.example.store.controller;

import com.example.store.dto.MonitorDTO;
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
@RequestMapping("/monitor")
@Tag(name = "Мониторы")
public class MonitorController {
    private final MonitorServiceImpl monitorServiceImpl;

    @Operation(summary = "Добавить новый монитор")
    @PostMapping()
    public ResponseEntity<MonitorDTO> addDevice(@Valid @RequestBody MonitorDTO dto) {
        return ResponseEntity.ok(monitorServiceImpl.addDevice(dto));
    }

    @Operation(summary = "Обновить информацию о мониторе")
    @PatchMapping()
    public ResponseEntity<MonitorDTO> updateDevice(@Valid @RequestBody MonitorDTO dto) {
        return ResponseEntity.ok(monitorServiceImpl.updateDevice(dto));
    }

}
