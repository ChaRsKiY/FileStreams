package streams;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        LibraryCatalog catalog = new LibraryCatalogImpl();
        catalog.initializeCatalog();
        catalog.displayCatalog();

        PrintedMaterial material = catalog.findMaterialByTitle("something");
        if (material != null) {
            System.out.println("Found material by title: " + material.getInfo());
        } else {
            System.out.println("Material not foun");
        }

        List<PrintedMaterial> materialsByAuthor = catalog.findMaterialsByAuthor("Arnold Popov");
        if (!materialsByAuthor.isEmpty()) {
            System.out.println("Found materials by author:");
            for (PrintedMaterial item : materialsByAuthor) {
                System.out.println(item.getInfo());
            }
        } else {
            System.out.println("No materials found");
        }

        catalog.saveCatalogToFile("catalog.ser");

        LibraryCatalog loadedCatalog = new LibraryCatalogImpl();
        loadedCatalog.loadCatalogFromFile("catalog.ser");
        loadedCatalog.displayCatalog();
    }
}

