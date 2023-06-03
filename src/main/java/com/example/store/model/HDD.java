package com.example.store.model;

import com.example.store.model.type.DeviceType;
import com.example.store.model.type.HDDCapacity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@DiscriminatorValue("HDD")
public class HDD extends Device {
    @Column (name = "hdd_capacity")
    private HDDCapacity hddCapacity;


}
