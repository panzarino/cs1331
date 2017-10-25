public class Book implements Legible, Comparable<Book> {
    private String title;
    private String author;
    private int numPages;

    public static int bookCount = 0;

    public Book(String title, String author, int numPages) {
        this.title = title;
        this.author = author;
        this.numPages = numPages;
        bookCount++;
    }

    public Book() {
        title = "Unknown";
        author = "Anonymous";
        numPages = 0;
        bookCount++;
    }

    public String toString() {
        return title + " written by " + author;
    }

    public boolean isLong() {
        return numPages > 300;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return numPages;
    }

    public int compareTo(Book other) {
        return this.numPages - other.numPages;
    }
}
