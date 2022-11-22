import java.util.Map;

public class Purchase {
    protected String title; //название
    protected int count; //количество

    public Purchase(String title, int count) { //конструктор для создания покупки одного товара
        this.title = title;
        this.count = count;
    }
}
