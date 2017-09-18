public class BookTester {
    public static void main(String[] args) {
        int value = 23;
        Book book1 = new Book("1984", "Orwell", 274);
        Book book2 = new Book("It", "King", 429);
        Book book3 = new Book();
        System.out.println(book1);
        System.out.println(book1.isLong());
        System.out.println(book2);
        System.out.println(book2.isLong());
        System.out.println(book3);
        System.out.println(book3.isLong());

        Book[] books = new Book[3];
        books[0] = new Book("Emma", "Austen", 245);
        books[1] = book1;
        books[2] = book2;

        System.out.println(book1.getTitle());
        book1.setTitle("Carrie");
        System.out.println(book1);
        changeArray(books);
        for (Book b : books) {
            System.out.println(b);
        }
        changeValue(value);
        System.out.println(value);

        System.out.println(Book.bookCount);

        System.out.println(sumPages(books));
    }

    public static void changeArray(Book[] myBooks) {
        for (int i = 0; i < myBooks.length; i++) {
            myBooks[i].setAuthor("McDaniel");
        }
    }

    public static void changeValue(int i) {
        i = 99;
    }

    public static int sumPages(Book[] myBooks) {
        int sum = 0;
        for (Book b : myBooks) {
            sum += b.getPages();
        }
        return sum;
    }
}
