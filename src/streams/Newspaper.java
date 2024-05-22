package streams;

import java.util.List;

class Newspaper extends PrintedMaterial {
    private String releaseDate;
    private List<String> headlines;

    public Newspaper(String title, String releaseDate, List<String> headlines) {
        super(title);
        this.releaseDate = releaseDate;
        this.headlines = headlines;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public List<String> getHeadlines() {
        return headlines;
    }

    @Override
    public String getInfo() {
        return "streams.Newspaper: " + getTitle() + ", Release Date: " + releaseDate + ", Headlines: " + headlines;
    }
}
