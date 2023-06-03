package com.example.store.model;

import com.example.store.model.type.DeviceType;
import com.example.store.model.type.PCFormFactor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@DiscriminatorValue("PC")
public class PC extends Device{
    @Column (name = "pc_form_factor")
    private PCFormFactor pcFormFactor;

}
