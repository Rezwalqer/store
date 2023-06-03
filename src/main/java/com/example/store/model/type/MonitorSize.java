package com.example.store.model.type;

import com.example.store.model.Monitor;

public enum MonitorSize {
    MONITOR_SIZE_25("25\""),
    MONITOR_SIZE_27("27\""),
    MONITOR_SIZE_29("29\""),
    MONITOR_SIZE_32("32\"");
    private final String value;

    MonitorSize(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
