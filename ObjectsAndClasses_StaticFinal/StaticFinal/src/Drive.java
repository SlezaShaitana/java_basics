public class Drive {
    private final DriveType driveType;
    private final int amountMemory;
    private final double driveWeight;

    public Drive(DriveType driveType, int amountMemory, double driveWeight) {
        this.driveType = driveType;
        this.amountMemory = amountMemory;
        this.driveWeight = driveWeight;
    }

    public DriveType getDriveType() {
        return driveType;
    }

    public int getAmountMemory() {
        return amountMemory;
    }

    public double getDriveWeight() {
        return driveWeight;
    }

    public String toString() {
        return "Накопитель информации " + "\n" +
                "Тип :" + driveType + "\n" +
                "Объем памяти :" + amountMemory + "ГБ" + "\n" +
                "Вес :" + driveWeight + "г";
    }
}
