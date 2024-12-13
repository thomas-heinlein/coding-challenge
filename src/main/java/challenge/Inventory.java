package challenge;

import java.util.List;
import java.util.NoSuchElementException;

public final class Inventory {

    private Inventory() {
    }

    private static final List<Product> instance = List.of(
            Product.of("A0001", 12.99),
            Product.of("A0002", 3.99)
    );

    public static List<Product> getInventory() {
        return instance;
    }

    public static Product getProduct(String productName) {
        if (productName == null) {
            throw new IllegalArgumentException("Product name cannot be null");
        }

        return instance.stream()
                .filter(p -> productName.equals(p.name()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Product not found"));
    }
}
