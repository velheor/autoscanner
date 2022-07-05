package com.autoscanner.model.autoscanner;

public enum Transmission {
    AUTOMATIC("Automatic"),
    MANUAL("Manual");

    private final String transmission;

    Transmission(final String transmission) {
        this.transmission = transmission;
    }

    public String getTransmission() {
        return transmission;
    }
}
