public class BookTester {
    public static void main(String[] args) {
        Book book1 = new Book("1984", "Orwell", 274);
        Book book2 = new Book("It", "King", 429);
        Book book3 = new Book();
        System.out.println(book1);
        System.out.println(book1.isLong());
        System.out.println(book2);
        System.out.println(book2.isLong());
        System.out.println(book3);
        System.out.println(book3.isLong());
    }
}
