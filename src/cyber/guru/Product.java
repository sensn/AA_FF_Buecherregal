package cyber.guru;
//https://www.baeldung.com/java-8-streams
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

    public static String analyseString(String sentence){
        String[] wordsInMessage = sentence.split("//s");
return null;
    }
    public static String analyseString1(String sentence){
        String[] wordsInMessage = sentence.split("//s");
        return "123";
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
