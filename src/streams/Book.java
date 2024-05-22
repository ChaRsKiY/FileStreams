package streams;

class Book extends PrintedMaterial {
    private String author;
    private String genre;
    private int pageCount;

    public Book(String title, String author, String genre, int pageCount) {
        super(title);
        this.author = author;
        this.genre = genre;
        this.pageCount = pageCount;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getPageCount() {
        return pageCount;
    }

    @Override
    public String getInfo() {
        return "streams.Book: " + getTitle() + ", Author: " + author + ", Genre: " + genre + ", Pages: " + pageCount;
    }
}
