public class Screen {
    private final double screenDiagonal;
    private final ScreenType screenType;
    private final double screenWeight;

    public Screen(double screenDiagonal, ScreenType screenType, double screenWeight) {
        this.screenDiagonal = screenDiagonal;
        this.screenType = screenType;
        this.screenWeight = screenWeight;
    }

    public double getScreenDiagonal() {
        return screenDiagonal;
    }

    public ScreenType getScreenType() {
        return screenType;
    }

    public double getScreenWeight() {
        return screenWeight;
    }


    public String toString() {
        return "Экран" + "\n" +
                "Диагональ :" + screenDiagonal + "дюйм" + "\n" +
                "Тип :" + screenType + "\n" +
                "Вес :" + screenWeight + "кг";
    }
}
