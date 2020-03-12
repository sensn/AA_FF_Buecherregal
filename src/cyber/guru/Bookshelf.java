package cyber.guru;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Bookshelf implements Iterable<Book> {
    String category;
    String location;
    List<Book> thebookslist = new ArrayList<Book>();      //for Comparable (.sort)

    Book[][] books;
    int rows=8;
    int columns=16;


    {
        books = new Book[rows][columns];
    }

    public String getCategory() {
        return category;
    }

    public Bookshelf() {
        this("default Category");
    }

    public Bookshelf(String category) {
      this(category,"default Location");

    }

    public Bookshelf(String category, String location) {
        this.category = category;
        this.location = location;
    }
    public void addbooks(Book book,int i,int j){
      if (books[i][j]==null) {
          books[i][j] = book;
          System.out.println("Buch in Bookshelf an Stelle " +i + " " +j +" eingefügt!");
      }else
          System.out.println("Hier steht schon ein Buch!");
    }
    public void addBookToList(Book book){      //for Comparable (.sort)
        thebookslist.add(book);
    }

    @Override
    public Iterator<Book> iterator() {
        return new Iterator<Book>() {
            int curRow = 0;
            int curColumn = 0;

            @Override
            public boolean hasNext() {
                if(curRow < rows && curColumn < columns){
                    return true;
                }
                return false;
            }

            @Override
            public Book next() {
                Book book = books[curRow][curColumn];
                curColumn++;

                if(curColumn == columns){
                    curRow++;
                    curColumn = 0;
                }
                return book;
            }
        };
    }


}
