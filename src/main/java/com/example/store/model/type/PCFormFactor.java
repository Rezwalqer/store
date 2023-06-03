package com.example.store.model.type;

public enum PCFormFactor {
    DESKTOP("Десктоп"),
    NETTOP("Неттоп"),
    MONOBLOCK("Моноблок");
    private final String value;

    PCFormFactor(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
