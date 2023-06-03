package com.example.store.controller;

import com.example.store.dto.HDDDto;
import com.example.store.dto.MonitorDTO;
import com.example.store.service.impl.HDDServiceImpl;
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
@RequestMapping("/hdd")
@Tag(name = "Жесткие диски")
public class HDDController {
    private final HDDServiceImpl hddServiceImpl;

    @Operation(summary = "Добавить новый жесткий диск")
    @PostMapping()
    public ResponseEntity<HDDDto> addDevice(@Valid @RequestBody HDDDto dto) {
        return ResponseEntity.ok(hddServiceImpl.addDevice(dto));
    }

    @Operation(summary = "Обновить информацию о жестком диске")
    @PatchMapping()
    public ResponseEntity<HDDDto> updateDevice(@Valid @RequestBody HDDDto dto) {
        return ResponseEntity.ok(hddServiceImpl.updateDevice(dto));
    }

}
