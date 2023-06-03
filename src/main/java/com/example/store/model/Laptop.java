package com.example.store.model;

import com.example.store.model.type.DeviceType;
import com.example.store.model.type.LaptopSize;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@DiscriminatorValue("Laptop")
public class Laptop extends Device{
    @Column (name = "laptop_size")
    private LaptopSize laptopSize;


}
