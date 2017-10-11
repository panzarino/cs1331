import java.util.ArrayList;

public class ArrayListTester {
    public static void main(String[] args) {
        ArrayList books = new ArrayList();
        books.add(new Book());
        books.add(new Novel());
        books.add(new Textbook());
        System.out.println(books);
        System.out.println(books.contains(new Book()));
        System.out.println(books.contains(new Novel()));
        System.out.println(books.contains(new Textbook()));
    }
}
