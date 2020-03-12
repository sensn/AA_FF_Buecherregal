package cyber.guru;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Book implements Comparable{
    String ISBN;
    String title;
    LocalDate pubDate;



    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getPubDate() {
        return pubDate;
    }

    public Book() {
        this("default");
    }

    public Book(String ISBN) {
      this(ISBN,"default title");
    }

    public Book(String ISBN, String title) {
        this(ISBN,title, LocalDate.of(1111,1,11));
       // this(ISBN,title, null);
    }

    public Book(String ISBN, String title, LocalDate pubDate) {
        this.ISBN = ISBN;
        this.title = title;
        this.pubDate = pubDate;
    }



    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", pubDate=" + pubDate +
                '}';
    }


    @Override
    public int compareTo(Object o) {
        Book book= (Book) o;
        return ((Integer.parseInt(this.getISBN()) < Integer.parseInt(book.getISBN())) ? -1: (Integer.parseInt(this.getISBN())> Integer.parseInt(book.getISBN())) ? 1:0 );

        //Read more: https://javarevisited.blogspot.com/2011/11/how-to-override-compareto-method-in.html#ixzz6GN8aPXxq
    }
}
