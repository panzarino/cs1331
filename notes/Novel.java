public class Novel extends Book {
    private String genre;
    public static final String[] VALID_GENRES = new String[]{
        "Horror", "SciFi", "Romance", "Nonfiction"
    };

    public Novel(String title, String author, int pages, String genre) {
        super(title, author, pages);
        setGenre(genre);
    }

    public Novel() {
        super();
        setGenre("Unknown");
    }

    public String toString() {
        return super.toString() + ", Genre: " + genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        if (contains(VALID_GENRES, genre)) {
            this.genre = genre;
        } else {
            this.genre = "Unknown";
        }
    }

    private boolean contains(String[] genres, String g) {
        for (String s : genres) {
            if (s.equals(g)) {
                return true;
            }
        }
        return false;
    }

    public String showIntials() {
        return getTitle().substring(0, 1) + getAuthor().substring(0, 1)
            + genre.substring(0, 1);
    }
}
