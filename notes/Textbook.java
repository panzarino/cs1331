public class Textbook extends Book {
    private String subject;

    public Textbook(String title, String author, int numPages, String subject) {
        super(title, author, numPages);
        this.subject = subject;
    }

    public Textbook() {
        super();
        subject = "Unknown";
    }

    @Override
    public String toString() {
        return super.toString() + " about " + subject;
    }

    @Override
    public boolean isLong() {
        return getPages() > 900;
    }
}
