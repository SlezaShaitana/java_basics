public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40, 16,40);
        basket.add("Cheese" ,13, 10,20);
        basket.print("Корзина" + "\n");

        Basket lidaBasket = new Basket();
        lidaBasket.add("Avocado", 56, 5, 46);
        lidaBasket.add("Lemon", 78, 7, 100);
        lidaBasket.print("Корзина" + "\n");

        System.out.println("\n" + "Количество корзин: " + Basket.getCount() + "\n" +
                "Общее количество всех товаров во всех корзинах: " + Basket.getAllBasketsItemsCount() + "\n" +
                "Общая стоимость: " + Basket.getAllBasketsPrice() + "\n" +
                "\n" + "Средняя цена товара: " + Basket.calculateItemAveragePrice() + "\n" +
                "Средняя стоимость корзины: " + Basket.calculateBasketAveragePrice());


        basket.clear();
        basket.print("");


    }
}
