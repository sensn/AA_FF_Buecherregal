package cyber.guru;

import java.util.Iterator;

public class Product implements Iterable {
    private String name;
    private int Price;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return Price;
    }

    public Product( int price, String name) {
        this.name = name;
        Price = price;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
