package challenge;

import java.math.BigDecimal;

public record Product(String name, BigDecimal price) {

    public static Product of(String name, double price) {
        return new Product(name, BigDecimal.valueOf(price));
    }
}
