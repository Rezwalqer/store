package com.example.store.dto;

import com.example.store.model.type.DeviceType;
import com.example.store.model.type.LaptopSize;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LaptopDTO extends DeviceDTO{
    private LaptopSize laptopSize;

}
