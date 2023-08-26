public class Elevator {
    private int currentFloor = 1;
    private int minFloor = -3;
    private int maxFloor = 26;

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }
    public int getCurrentFloor() {
        return currentFloor;
    }
    public void moveDown() {
        currentFloor = currentFloor -1;
    }
    public void moveAp() {
        currentFloor = currentFloor +1;
    }
    public void move(int floor) {
        if (floor == currentFloor || floor < minFloor || floor > maxFloor) {
            System.out.println("Этаж введен неверно");
        }
        while (currentFloor != floor) {
            if (currentFloor > floor) {
                moveDown();
                System.out.println("Текущий этаж: " + currentFloor);
            }
            if (currentFloor < floor) {
                moveAp();
                System.out.println("Текущий этаж:" + currentFloor);
            }
        }
    }
}