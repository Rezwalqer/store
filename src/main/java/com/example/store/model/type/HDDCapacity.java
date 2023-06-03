package com.example.store.model.type;

public enum HDDCapacity {
    SIZE_128GB("128GB"),
    SIZE_256GB("256GB"),
    SIZE_512GB("512GB"),
    SIZE_1024GB("1024GB");
    private final String value;

    HDDCapacity(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
