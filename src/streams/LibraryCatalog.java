package streams;

import java.util.List;

interface LibraryCatalog {
    void initializeCatalog();

    void displayCatalog();

    PrintedMaterial findMaterialByTitle(String title);

    List<PrintedMaterial> findMaterialsByAuthor(String author);

    void saveCatalogToFile(String fileName);

    void loadCatalogFromFile(String fileName);
}
