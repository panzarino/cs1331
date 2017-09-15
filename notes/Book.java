public class Book {
    private String title;
    private String author;
    private int numPages;

    public Book(String title, String author, int numPages) {
        this.title = title;
        this.author = author;
        this.numPages = numPages;
    }

    public Book() {
        title = "Unknown";
        author = "Anonymous";
        numPages = 0;
    }

    public String toString() {
        return title + " written by " + author;
    }

    public boolean isLong() {
        return numPages > 300;
    }
}
