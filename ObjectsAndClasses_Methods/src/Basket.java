public class Basket {

    private static int allBasketsItemsCount = 0;
    private static int allBasketsPrice = 0;

    private static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;
    private double totalWeight = 0;

    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }

    public static int getCount() {
        return count;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    public void add( String name, int price, int count, double weight) {
        add(name, price, count);
        items = items + weight;
        totalWeight = totalWeight + (count * weight);
    }

    public void add(String name, int price) {
        add(name, price, 1);
    }

    public void add(String name, int price, int count) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
            count + " шт. - " + price + " ";
        totalPrice = totalPrice + count * price;
        increaseAllBasketsItemsCount(count);
        increaseAllBasketsPrice(price, count);
    }

    public void clear() {
        items = "";
        totalPrice = 0;
        totalWeight = 0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items +
                    "\n" + "Общая стоимость корзины :" + totalPrice +
                    "\n" + "Общий вес корзины :" + totalWeight);
        }
    }

    public static void increaseAllBasketsItemsCount(int count) {
        allBasketsItemsCount = allBasketsItemsCount + count;
    }

    public static void increaseAllBasketsPrice(int price, int count) {
        allBasketsPrice = allBasketsPrice + count * price;
    }

    public static int getAllBasketsItemsCount() {
        return allBasketsItemsCount;
    }

    public static int getAllBasketsPrice() {
        return allBasketsPrice;
    }

    public static double calculateItemAveragePrice() {
        return allBasketsPrice / allBasketsItemsCount;
    }
    public static double calculateBasketAveragePrice() {
        return allBasketsPrice / count;
    }
}
