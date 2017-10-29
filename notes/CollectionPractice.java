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
        books.add(new Book("Emma", "Austen", 522));
        books.add(new Book("1922", "King", 189));
        books.add(new Book("Silas Marner", "Eliot", 700));
        Collections.sort(books);
        System.out.println(books);
        Collections.sort(books, new AuthorComparator());
        System.out.println(books);

        ArrayList<Doberman> dogs = new ArrayList<>();
        dogs.add(new Doberman());
        dogs.add(new Doberman("Blackie"));
        dogs.add(new Doberman("Sweetie"));
        Collections.sort(dogs, (a, b) -> {
            return a.getName().compareTo(b.getName());
        });
        System.out.println(dogs);
    }
}
