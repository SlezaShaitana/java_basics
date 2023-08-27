public class Elevator {
    private int currentFloor = 1;
    private int minFloor;
    private int maxFloor;

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }
    public int getCurrentFloor() {
        return currentFloor;
    }
    public void moveDown() {
        currentFloor = currentFloor > minFloor ? currentFloor - 1 : currentFloor;
    }
    public void moveAp() {
        currentFloor = currentFloor < maxFloor ? currentFloor +1 : currentFloor;
    }
    public void move(int floor) {
        while (currentFloor != floor) {
            if (floor == currentFloor || floor < minFloor || floor > maxFloor) {
                System.out.println("Этаж введен неверно");
            }

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