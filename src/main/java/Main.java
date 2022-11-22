import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HashMap<String, Integer> products = new HashMap<>();  //заводится информация о товарах и ценах через мапу
        products.put("Хлеб", 56);
        products.put("Масло", 153);
        products.put("Колбаса", 211);
        products.put("Пирожок", 45);

        System.out.println("В МАГАЗИНЕ В НАЛИЧИИ");  //выводится на экран состав магазина
        for (Map.Entry<String, Integer> productAndPrice : products.entrySet()) {
            System.out.println(productAndPrice.getKey() + " за " + productAndPrice.getValue() + " руб./шт.");
        }

        System.out.println("Введите два слова: название товара и количество. Или end");
        Scanner scanner = new Scanner(System.in);
        Basket purchase = new Basket(products);  //создаем корзину
        //название корзины меняем на Basket с purchase
        //сюда передаем products
        while (true) {
            String line = scanner.nextLine();  //считываем что введено
            if ("end".equals(line)) break;
            String[] parts = line.split(" "); //разбиваем на 2 части
            String product = parts[0];
            int count = Integer.parseInt(parts[1]);
            purchase.addPurchase(product, count);  //корзине говорим добавить покупку
        }
        long sum = purchase.sum();  //просим корзину вывести сумму, передаем туда название товаров
        //тут убираем products в скобках
        System.out.println("ИТОГО: " + sum);
    }
}
