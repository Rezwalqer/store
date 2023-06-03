package com.example.store.dto;

import com.example.store.model.type.DeviceType;
import com.example.store.model.type.HDDCapacity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HDDDto extends DeviceDTO{
    private HDDCapacity hddCapacity;

}

