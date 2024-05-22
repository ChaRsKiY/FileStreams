package streams;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class LibraryCatalogImpl implements LibraryCatalog {
    private List<PrintedMaterial> catalog;

    public LibraryCatalogImpl() {
        catalog = new ArrayList<>();
    }

    @Override
    public void initializeCatalog() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 180));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", 281));
        books.add(new Book("1984", "George Orwell", "Dystopian", 328));

        List<String> headlines = new ArrayList<>();
        headlines.add("Headline 1");
        headlines.add("Headline 2");
        headlines.add("Headline 3");

        catalog.add(new Book("Book1", "Author1", "Genre1", 100));
        catalog.add(new Newspaper("Newspaper1", "2024-05-01", headlines));
        catalog.add(new Almanac("Almanac1", books));
    }

    @Override
    public void displayCatalog() {
        for (PrintedMaterial material : catalog) {
            System.out.println(material.getInfo());
        }
    }

    @Override
    public PrintedMaterial findMaterialByTitle(String title) {
        for (PrintedMaterial material : catalog) {
            if (material.getTitle().equalsIgnoreCase(title)) {
                return material;
            }
        }
        return null;
    }

    @Override
    public List<PrintedMaterial> findMaterialsByAuthor(String author) {
        List<PrintedMaterial> materialsByAuthor = new ArrayList<>();
        for (PrintedMaterial material : catalog) {
            if (material instanceof Book && ((Book) material).getAuthor().equalsIgnoreCase(author)) {
                materialsByAuthor.add(material);
            }
        }
        return materialsByAuthor;
    }

    @Override
    public void saveCatalogToFile(String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(catalog);
            System.out.println("Catalog saved to file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving catalog to file: " + e.getMessage());
        }
    }

    @Override
    public void loadCatalogFromFile(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            catalog = (List<PrintedMaterial>) inputStream.readObject();
            System.out.println("Catalog loaded from file: " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading catalog from file: " + e.getMessage());
        }
    }
}
