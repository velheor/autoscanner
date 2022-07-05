package com.autoscanner.model.autoscanner;

public enum EngineType {
    PETROL("Petrol"),
    DIESEL("Diesel"),
    ELECTRO("Electro"),
    ANOTHER("Another");

    private final String engineType;

    EngineType(final String engineType) {
        this.engineType = engineType;
    }

    public String getEngineType() {
        return engineType;
    }
}
