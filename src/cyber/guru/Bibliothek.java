package cyber.guru;

import java.util.ArrayList;
import java.util.List;

public class Bibliothek {
    String name="Default Bibliothek";
    List<Bookshelf> thebookshelfs = new ArrayList<Bookshelf>();

    public String getName() {
        return name;
    }

    public List<Bookshelf> getThebookshelfs() {
        return thebookshelfs;
    }

    public Bibliothek() {
        this("default Bibliothek");
    }

    public Bibliothek(String name) {
        this.name = name;
    }

    public void addBookshelf(Bookshelf bookshelf){
        this.thebookshelfs.add(bookshelf);
    }

}
