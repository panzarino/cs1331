public class BookTester {
    public static void main(String[] args) {
        Novel book1 = new Novel("1984", "Orwell", 274, "SciFi");
        Book book2 = new Book("It", "King", 429);
        Book book3 = new Book();

        Book[] books = new Book[]{book1, book2, book3};
        for (Book b : books) {
            System.out.println(b);
            System.out.println(b.getTitle());
        }

        System.out.println(book1.showIntials());
    }
}
