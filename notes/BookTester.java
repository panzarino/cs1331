public class BookTester {
    public static void main(String[] args) {
        Novel book1 = new Novel("1984", "Orwell", 274, "SciFic");
        Novel book2 = new Novel("It", "King", 429, "Horror");
        Book book3 = new Book();
        Book book4 = new Book();

        Book[] books = new Book[]{book1, book2, book3};

        System.out.println(book3.equals(book4));
        System.out.println(book3 == book4);

        for (Book b : books) {
            System.out.println(b);
            System.out.println(b.getTitle());
        }

        System.out.println(book1.showIntials());
        System.out.println(book2.showIntials());
    }
}
