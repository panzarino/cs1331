public class Novel extends Book {
    private Genre genre;

    public Novel(String title, String author, int pages, Genre genre) {
        super(title, author, pages);
        setGenre(genre);
    }

    public Novel() {
        super();
        setGenre(Genre.GENERAL);
    }

    public String toString() {
        return super.toString() + ", Genre: " + genre;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
