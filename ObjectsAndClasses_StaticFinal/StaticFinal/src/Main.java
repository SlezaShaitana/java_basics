public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer("Asus", "Computer User",
                new Processor( 2.60, 8, ManufacturerCpu.INTEL, 0.9),
                        new Ram(RamType.DDR4_SDRAM, 8, 0.23),
                        new Drive(DriveType.SSD, 512, 0.700),
                        new Screen(23.8, ScreenType.IPS, 8.0),
                        new Keyboard(KeyboardType.MECHANICAL,true, 1.300));

        System.out.println(computer);

        Computer computer2 = new Computer("Samsung", "Computer User2",
                new Processor( 2.60, 8, ManufacturerCpu.AMD_RYZEN, 0.7),
                new Ram(RamType.DDR5_SDRAM, 6, 0.15),
                new Drive(DriveType.HDD, 650, 0.900),
                new Screen(23.8, ScreenType.IPS, 5.0),
                new Keyboard(KeyboardType.MECHANICAL,false, 1.100));

        System.out.println(computer2);
    }

}
