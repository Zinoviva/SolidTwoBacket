import java.util.Map;

public class Basket {
    //Purchase используется и для объекта корзины и для объекта покупки одного товара -нарушение принципа единой ответственности
//переноси сюда то, что связано с корзиной
    protected Map<String, Integer> prices;  //добавляем хранение ассортимента
    //    protected Purchase[] purchases = new Purchase[4];  //у корзины есть список покупок, цифра 4 магическое число
    protected Purchase[] purchases;

    public Basket(Map<String, Integer> prices) { //пустой конструктор - создание пустой корзины
        //переименовать на баскет с Purchase
        //добавлили на этап конструирования Map<String, Integer> prices в скобки
        this.prices = prices; //на этапе создания корзины передаем ассортимент
        //тут же создаем корзину для покупок(убираем сверху, где было магическое число,потому что нельзя обратиться через прайс.сайз,т.к. сначала в ассортименте нал
        this.purchases = new Purchase[prices.size()];
    }

    public void addPurchase(String title, int count) {  //добавление одного товара
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) {  //ищем пустую ячейку массива
                purchases[i] = new Purchase(title, count);  //как находим создаем с названием и количеством
                return;  //уходим
            }
            if (purchases[i].title.equals(title)) {  //если был товар с этим названием товара прибавляем
                purchases[i].count += count;
                return;
            }
        }
    }

    // public long sum(Map<String, Integer> prices) {  //метод суммирования, принимает информацию об ассортименте и выводит на экран
    public long sum() { //не передаем ассортимент, передаем его на этапе конструирования корзины в конструкторе public Purchase
        //джава не следит чтобы передали тот же самый ассортимент
        long sum = 0;
        System.out.println("КОРЗИНА:");
        for (int i = 0; i < purchases.length; i++) {
            Purchase purchase = purchases[i];
            if (purchase == null) continue;
            System.out.println("\t" + purchase.title + " " + purchase.count + " шт. в сумме " + (purchase.count * prices.get(purchase.title)) + " руб.");
            sum += purchase.count * prices.get(purchase.title);
        }
        return sum;
    }
}
