package com.example.store.model.type;

public enum LaptopSize {
    LAPTOP_SIZE_13("13\""),
    LAPTOP_SIZE_14("14\""),
    LAPTOP_SIZE_15("15\""),
    LAPTOP_SIZE_17("17\"");
    private final String value;

    LaptopSize(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
