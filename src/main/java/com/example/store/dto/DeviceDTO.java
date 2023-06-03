package com.example.store.dto;

import com.example.store.model.type.DeviceType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class DeviceDTO {
    private Integer id;
    private String serialNumber;
    @NotNull
    private String producer;
    @Positive
    private int price;
    @Positive
    @Min(1)
    private int quantity;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private DeviceType deviceType;
}
