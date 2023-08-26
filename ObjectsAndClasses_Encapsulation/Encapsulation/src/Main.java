import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Dimensions dimensions = new Dimensions(1.50, 2.7, 3.9);
        System.out.println(dimensions);
        dimensions = dimensions.setLength(62.8);
        dimensions = dimensions.setWidth(43.0);
        dimensions = dimensions.setHeight(43.2);
        System.out.println( "\n" + "Длина: " + dimensions.getLength());

        Cargo cargo = new Cargo(dimensions, 65, "Горького", true,
                "ug5t655", false);
        cargo.setLength(890);
        System.out.println(cargo);

        cargo = cargo.setDeliveryAddress("Юбилейная");
        System.out.println( "\n" + "Адрес доставки: " + cargo.getDeliveryAddress());


        Elevator elevator = new Elevator(-3, 26);
        while (true) {
            System.out.println( "\n" + "Введите номер этажа :");
            int floor = new Scanner(System.in).nextInt();
            elevator.move(floor);
        }

    }
}
