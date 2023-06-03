package com.example.store.model;

import com.example.store.model.type.DeviceType;
import com.example.store.model.type.HDDCapacity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@ToString
@Entity
@Table(name = "devices")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "bd_type")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (name = "serial_number")
    private String serialNumber;
    private String producer;
    private int price;
    private int quantity;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column (name = "device_type")
    private DeviceType deviceType;

}
