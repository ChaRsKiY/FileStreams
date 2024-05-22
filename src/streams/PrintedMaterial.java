package streams;

import java.io.Serializable;

abstract class PrintedMaterial implements Serializable {
    private String title;

    public PrintedMaterial(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract String getInfo();
}
