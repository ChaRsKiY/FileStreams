package streams;

import java.util.List;

class Almanac extends PrintedMaterial {
    private List<Book> works;

    public Almanac(String title, List<Book> works) {
        super(title);
        this.works = works;
    }

    public List<Book> getWorks() {
        return works;
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("streams.Almanac: ").append(getTitle()).append(", Works:\n");
        for (Book book : works) {
            sb.append("\t").append(book.getTitle()).append(" by ").append(book.getAuthor()).append("\n");
        }
        return sb.toString();
    }
}
