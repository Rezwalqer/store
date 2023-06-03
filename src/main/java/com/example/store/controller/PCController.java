package com.example.store.controller;

import com.example.store.dto.MonitorDTO;
import com.example.store.dto.PCDto;
import com.example.store.service.impl.MonitorServiceImpl;
import com.example.store.service.impl.PCServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pc")
@Tag(name = "Настольные компьютеры")
public class PCController {
    private final PCServiceImpl pcServiceImpl;

    @Operation(summary = "Добавить новый компьютер")
    @PostMapping()
    public ResponseEntity<PCDto> addDevice(@Valid @RequestBody PCDto dto) {
        return ResponseEntity.ok(pcServiceImpl.addDevice(dto));
    }

    @Operation(summary = "Обновить информацию о компьютере")
    @PatchMapping()
    public ResponseEntity<PCDto> updateDevice(@Valid @RequestBody PCDto dto) {
        return ResponseEntity.ok(pcServiceImpl.updateDevice(dto));
    }

}
