package com.example.store.dto;

import com.example.store.model.type.DeviceType;
import com.example.store.model.type.MonitorSize;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MonitorDTO extends DeviceDTO {
    private MonitorSize monitorSize;
}
