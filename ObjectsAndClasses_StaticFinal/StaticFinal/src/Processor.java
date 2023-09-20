public class Processor {
    private final double frequencyCpu;
    private final int coresCount;

    private final ManufacturerCpu manufacturerCpu;
    private final double weightCPU;

    public Processor(double frequencyCpu,int coresCount,
                     ManufacturerCpu manufacturerCpu, double weightCPU) {
        this.frequencyCpu = frequencyCpu;
        this.coresCount = coresCount;
        this.manufacturerCpu = manufacturerCpu;
        this.weightCPU = weightCPU;
    }

    public double getFrequencyCpu() {
        return frequencyCpu;
    }

    public int getCoresCount() {
        return coresCount;
    }

    public ManufacturerCpu getManufacturerCpu() {
        return manufacturerCpu;
    }

    public double getWeightCPU() {
        return weightCPU;
    }

    public String toString() {
        return "Процессор. " + "\n" +
                "Частота: " + frequencyCpu + "ГГц" + "\n" +
                "Количество ядер: " + coresCount + "шт" + "\n" +
                "Производитель: " + manufacturerCpu + "\n" +
                "Вес: " + weightCPU + "г";
    }
}
