package by.grsu.model.autoscanner;

public enum VehicleType {
    /**
     * внедорожник
     */
    SUV("Suv"),
    /**
     * кабриолет
     */
    CABRIOLET("Cabriolet"),
    /**
     * купе
     */
    COUPE("Coupe"),
    /**
     * Другое
     */
    ANOTHER("Another"),
    /**
     * хэтчбек
     */
    HATCHBACK("Hatchback"),
    /**
     * универсал
     */
    WAGON("Wagon"),
    /**
     * седан
     */
    SEDAN("Sedan"),
    /**
     * пикап
     */
    PICKUP("Sedan"),
    /**
     * минивен
     */
    MINIVAN("Minivan"),
    /**
     * микроавтобус
     */
    MINIBUS("Minibus"),
    /**
     * лифтбек
     */
    LIFTBACK("Liftback"),
    /**
     * лимузин
     */
    LIMOUSINE("Limousine"),
    /**
     * фургон
     */
    VAN("Van");

    private final String vehicleType;

    VehicleType(final String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleType() {
        return vehicleType;
    }
}
