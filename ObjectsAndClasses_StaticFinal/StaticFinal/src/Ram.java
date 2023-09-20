public class Ram {
    private final RamType ramType;
    private final int volumeRam;
    private final double weightRam;

    public Ram(RamType ramType, int volumeRam, double weightRam) {
        this.ramType = ramType;
        this.volumeRam = volumeRam;
        this.weightRam = weightRam;
    }

    public RamType getRamType() {
        return ramType;
    }

    public int getVolumeRam() {
        return volumeRam;
    }

    public double getWeightRam() {
        return weightRam;
    }

    public String toString() {
        return "Оперативная память " +"\n" +
                "Тип :" + ramType + "\n" +
                "Объем :" + volumeRam + "\n" +
                "Вес :" + weightRam + "г";
    }
}
