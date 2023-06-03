package com.example.store.model;

import com.example.store.model.type.DeviceType;
import com.example.store.model.type.MonitorSize;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@DiscriminatorValue("Monitor")
public class Monitor extends Device {
    @Column (name = "monitor_size")
    private MonitorSize monitorSize;

}
