public class Keyboard {
    private final KeyboardType keyboardType;
    private final boolean hasBacklit;
    private final double keyboardWeight;

    public Keyboard(KeyboardType keyboardType, boolean hasBacklit, double keyboardWeight) {
        this.keyboardType = keyboardType;
        this.hasBacklit = hasBacklit;
        this.keyboardWeight = keyboardWeight;
    }

    public KeyboardType getKeyboardType() {
        return keyboardType;
    }

    public boolean isHasBacklit() {
        return hasBacklit;
    }

    public double getKeyboardWeight() {
        return keyboardWeight;
    }

    public String toString() {
        return "Клавиатура" + "\n" +
                "Тип :" + keyboardType + "\n" +
                "Наличие подсветки :" + (hasBacklit? "Есть" : "Нет") + "\n" +
                "Вес :" + keyboardWeight;
    }
}
