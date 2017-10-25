import java.util.ArrayList;
import java.util.Collections;

public class CollectionPractice {
    public static void main(String[] args) {
        ArrayList<String> pets = new ArrayList<>();
        pets.add("Rabbit");
        pets.add("Cat");
        pets.add("Dog");
        String mypet = pets.get(0);
        Collections.sort(pets);

        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book());
        books.add(new Book("Moby Dick", "Melville", 499));
        books.add(new Book("It", "King", 389));
        Collections.sort(books);
        System.out.println(books);
    }
}
