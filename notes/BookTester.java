public class BookTester {
    public static void main(String[] args) {
        Book book1 = new Novel("1984", "Orwell", 274, "SciFic");
        Book book2 = new Novel("It", "King", 429, "Horror");
        Book book3 = new Textbook();
        Book book4 = new Textbook();
        Book book5 = new Novel();

        Book[] books = new Book[]{book1, book2, book3, book4, book5};

        System.out.println(book3.equals(book4));
        System.out.println(book3 == book4);

        for (Book b : books) {
            System.out.println(b);
        }

        System.out.println(book1.compareTo(book2));

        System.out.println(((Novel) book1).getGenre());
    }
}
