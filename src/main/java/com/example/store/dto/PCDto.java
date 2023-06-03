package com.example.store.dto;

import com.example.store.model.type.DeviceType;
import com.example.store.model.type.PCFormFactor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PCDto extends DeviceDTO {

    private PCFormFactor pcFormFactor;
}
