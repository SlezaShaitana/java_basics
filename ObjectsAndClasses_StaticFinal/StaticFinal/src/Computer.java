public class Computer {
    public Processor processor;
    public Ram ram;
    public Drive drive;
    public Screen screen;
    public Keyboard keyboard;
    public final String vendor;
    public final String name;
    public double totalWeightComputer;

    public Computer(String vendor, String name,Processor processor, Ram ram, Drive drive, Screen screen,
                    Keyboard keyboard) {
        this.vendor = vendor;
        this.name = name;
        this.processor = processor;
        this.ram = ram;
        this.drive = drive;
        this.screen = screen;
        this.keyboard = keyboard;
        calculateTotalWeight();

    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public void setDrive(Drive drive) {
        this.drive = drive;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }
    public Processor getProcessor() {
        return processor;
    }

    public Ram getRam() {
        return ram;
    }

    public Drive getDrive() {
        return drive;
    }

    public Screen getScreen() {
        return screen;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public String getVendor() {
        return vendor;
    }

    public String getName() {
        return name;
    }



    public double calculateTotalWeight() {
        return totalWeightComputer = processor.getWeightCPU() + ram.getWeightRam() +
                drive.getDriveWeight() + screen.getScreenWeight() + keyboard.getKeyboardWeight();
    }

    public String toString() {
        return "Информация о компьютере :" + "\n" +
                "Название :" + name + "\n" +
                "Производитель :" + vendor +
                "\n" + processor +
                "\n" + ram +
                "\n" + drive +
                "\n" + screen +
                "\n" + keyboard + "\n" +
                "\n" + "Общая масса компьютера :" + totalWeightComputer +"\n";
    }


}
