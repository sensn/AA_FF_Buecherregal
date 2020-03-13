package cyber.guru;

import org.junit.jupiter.api.*;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

enum DaysOfWeekEnum {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY
}

public class Main {




    public static void main(String[] args) throws IOException {
        // write your code here
        Main main=new Main();
        main.run   ();
    }

    public void run() throws IOException {
        Consumer<String> pressanykey = (anystring) -> {
            System.out.println(anystring);
            Scanner scanner = new Scanner(System.in);
            String str4 = scanner.nextLine();
        };
        IntConsumer myIntConsumer = (anyint) -> {
            System.out.println(anyint);
        };
        myIntConsumer.accept(55);

        Bibliothek bibliothek = new Bibliothek();
        bibliothek.addBookshelf(new Bookshelf());


        for (int i = 0; i < bibliothek.thebookshelfs.get(0).books.length; i++) {
            for (int j = 0; j < bibliothek.thebookshelfs.get(0).books[i].length; j++) {
                //  bibliothek.thebookshelfs.get(0).addbooks(new Book(),i,j);
                bibliothek.thebookshelfs.get(0).addbooks(new Book(String.valueOf(i * 16 + j)), i, j);
                //bibliothek.thebookshelfs.get(0).addBookToList(new Book(Character.toString((char)(i*16 +j))));
                bibliothek.thebookshelfs.get(0).addBookToList(new Book(String.valueOf(i * 16 + j)));
            }
        }
        //Arrays.sort(bibliothek.thebookshelfs.get(0).books);  //Geht Anita

        //  Arrays.sort(bibliothek.thebookshelfs.get(0).books,  (a, b) -> Integer.parseInt(b[0].getISBN()) - Integer.parseInt(a[0].getISBN()));
        //  Arrays.sort(bibliothek.thebookshelfs.get(0).books,  (a, b) -> Integer.parseInt(b[0].getISBN()) - Integer.parseInt(a[0].getISBN()));

        Arrays.sort(bibliothek.thebookshelfs.get(0).books, new java.util.Comparator<Book[]>() {
            public int compare(Book[] a, Book[] b) {
                return (Integer.parseInt(a[0].getISBN()) > Integer.parseInt(b[0].getISBN()) ? -1 : (Integer.parseInt(a[0].getISBN()) < Integer.parseInt(b[0].getISBN()) ? 1 : 0));   //reversed per row
                // return (a[0].compareTo(b[0]));
            }
        });


        Bookshelf shelf = bibliothek.thebookshelfs.get(0);
        for (Book book : shelf) {
            System.out.println(book);

        }


        pressanykey.accept("Press Return to proceed...");
        printPBook(shelf, book -> book.pubDate.isBefore(LocalDate.of(1999, 1, 1)));
        // bibliothek.thebookshelfs.get(0).books.


        Comparator<Book> comparator = (h1, h2) -> (Integer.parseInt(h1.getISBN()) > Integer.parseInt(h2.getISBN()) ? 1 : (Integer.parseInt(h1.getISBN()) < Integer.parseInt(h2.getISBN()) ? -1 : 0));
        //Comparator<Book> comparator = (h1,h2) -> h1.getISBN().compareTo(h2.getISBN());

        bibliothek.thebookshelfs.get(0).thebookslist.sort(comparator);                      //Comparator
        //  bibliothek.thebookshelfs.get(0).thebookslist.sort(Comparator.comparing(Book::getISBN));                      //Comparator
        //   bibliothek.thebookshelfs.get(0).thebookslist.sort(comparator.reversed());
        //  Collections.sort(bibliothek.thebookshelfs.get(0).thebookslist, Comparator.comparing(Book::getISBN));
        //  bibliothek.thebookshelfs.get(0).thebookslist.sort(Comparator.comparing(Book::getISBN).thenComparing(Book::getTitle) );


        // bibliothek.thebookshelfs.get(0).thebookslist.sort(
        //           (Book h1, Book h2) -> h1.getISBN().compareTo(h2.getISBN()));


        for (Book book : shelf.thebookslist) {                             //Comparator print sorted list
            System.out.println(book);
        }

        //  int x=  System.in.read();

        //   bibliothek.thebookshelfs.get(0).thebookslist.forEach((Book book) -> System.out.println("Consumer BOOK: "+ book.getTitle()));     //Consumer


        pressanykey.accept("Press Return to proceed...");
        System.out.println("HUHUHU");

// Passing a Runnable when creating a new thread
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " is running");
            }
        });
        thread2.start();

        // Lambda Runnable
        Runnable task1 = () -> {
            System.out.printf(Thread.currentThread().getName() + " is running Task1");
        };
        new Thread(task1).start();

        //SUPPLIER
        // This function returns a random value.


        Random wuerfel = new Random();

        Supplier<Integer> randomValue1 = () -> wuerfel.nextInt(9);
        Supplier<Double> randomValue = () -> Math.random() * 10;

        // Print the random value using get()
        System.out.println(randomValue.get());
        System.out.println(randomValue1.get());

        // Iterate over enum

        for (DaysOfWeekEnum day : DaysOfWeekEnum.values()) {
            System.out.println(day);
        }

        //We can also use java.util.Stream. So that we can perform operations on the Enum values.
        //
        //To create a Stream we have two options, one using Stream.of:
        Stream.of(DaysOfWeekEnum.values());
        //
        //  7.2. The collect() Method

        List<Product> productList = Arrays.asList(new Product(23, "potatoes"),
                new Product(14, "orange"), new Product(13, "lemon"),
                new Product(23, "bread"), new Product(13, "sugar"));

      //  Converting a stream to the Collection (Collection, List or Set):
        List<String> collectorCollection =
                productList.stream().map(Product::getName).collect(Collectors.toList());

        //Reducing to String:
        String listToString = productList.stream().map(Product::getName)
                .collect(Collectors.joining(", ", "[", "]"));

        //Processing the average value of all numeric elements of the stream:
        double averagePrice = productList.stream()
                .collect(Collectors.averagingInt(Product::getPrice));

        int summingPrice = productList.stream()
                .collect(Collectors.summingInt(Product::getPrice));

        System.out.println(listToString);

        //Collecting statistical information about stream’s elements:
        IntSummaryStatistics statistics = productList.stream()
                .collect(Collectors.summarizingInt(Product::getPrice));
        System.out.println(statistics);

     //   Grouping of stream’s elements according to the specified function:
        Map<Integer, List<Product>> collectorMapOfLists = productList.stream()
                .collect(Collectors.groupingBy(Product::getPrice));


        for (Map.Entry<Integer, List<Product>> entry : collectorMapOfLists.entrySet()) {
            List<Product> my = entry.getValue();
            for (Product prod:my
                 ) {
                System.out.println(prod.getName());
            }
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
        final long[] i = {0};
     //   collectorMapOfLists.forEach((k, v) -> {i[0] += k + k;System.out.println(i[0])});

       // System.out.println(collectorMapOfLists);
    }
    public static void printPBook(Bookshelf shelf, Predicate<Book> predicate) {
        for (Book book : shelf) {
            if (predicate.test(book)) {
                System.out.print("Before: " + book + " ");
            }
        }
        System.out.println();
    }
}