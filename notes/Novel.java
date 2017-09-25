public class Novel extends Book {
    private String genre;

    public Novel(String title, String author, int pages, String genre) {
        super(title, author, pages);
        this.genre = genre;
    }

    public String toString() {
        return super.toString() + ", Genre: " + genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String showIntials() {
        return getTitle().substring(0, 1) + getAuthor().substring(0, 1)
            + genre.substring(0, 1);
    }
}
