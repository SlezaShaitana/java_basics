public class Cargo {
    private final Dimensions dimensions;
    private final double mass;
    private final String deliveryAddress;
    private final boolean canTurning;
    private final String registrationNumber;
    private final boolean fragile;

    public Cargo(Dimensions dimensions, double mass, String deliveryAddress,
                 boolean canTurning, String registrationNumber, boolean fragile) {
        this.dimensions = dimensions;
        this.mass = mass;
        this.deliveryAddress = deliveryAddress;
        this.canTurning = canTurning;
        this.registrationNumber = registrationNumber;
        this.fragile = fragile;
    }

    public String toString() {
        return  "\n" + "Масса: " + mass + "\n" + "Адрес доставки: " + deliveryAddress +
                "\n" + "можно ли переворачивать: " + (canTurning ? "Да" : "Нет") +
                "\n" + "Регистрационный номер: " + registrationNumber +
                "\n" + "Хрупкое: " + (fragile ? "Да" : "Нет" ) +
                "\n" + dimensions;
    }

    public Cargo setDeliveryAddress(String deliveryAddress) {
        return new Cargo(dimensions, mass, deliveryAddress, canTurning, registrationNumber, fragile);
    }

    public Cargo setDimensions(Dimensions dimensions) {
        return new Cargo(dimensions, mass, deliveryAddress, canTurning, registrationNumber, fragile);

    }

    public Cargo setMass(double mass) {
        return new Cargo(dimensions, mass, deliveryAddress, canTurning, registrationNumber, fragile);

    }

    public Cargo setWidth(double width) {
        return new Cargo(dimensions, mass, deliveryAddress, canTurning, registrationNumber, fragile);
    }

    public Cargo setLength(double length) {
        return new Cargo(dimensions, mass, deliveryAddress, canTurning, registrationNumber, fragile);
    }
    public Dimensions getDimensions() {
        return dimensions;
    }

    public double getMass() {
        return mass;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public boolean isCanTurning() {
        return canTurning;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public boolean isFragile() {
        return  fragile;
    }
}
