public class Arithmetic {
    public int a;
    public int b;
    public int sum;
    public int sum1;

    public Arithmetic(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int addition() {
        sum1 = a + b;
        return sum1;
    }
    public int productOfNumber() {
        sum = a * b;
        return sum;
    }
    public int maxCount() {
        if (a > b) {
            return a;
        } return b;
    }
    public int minCount() {
        if (a < b) {
            return a;
        } return b;
    }

}
