package challenge;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InventoryTest {

    @Test
    void cannot_append_product() {
        assertThrows(
                UnsupportedOperationException.class,
                () -> Inventory.getInventory().add(Product.of("some product", 0))
        );
    }

    @Nested
    class GetProduct {

        Product EXISTING_PRODUCT = Inventory.getInventory().getFirst();

        @Test
        void get_product_by_name() {
            Product foundProduct = Inventory.getProduct(EXISTING_PRODUCT.name());

            assertThat(foundProduct).isEqualTo(EXISTING_PRODUCT);
        }

        @Test
        void throw_exception_when_no_product_found() {
            assertThrows(
                    NoSuchElementException.class,
                    () -> Inventory.getProduct("no such product")
            );
        }

        @Test
        void throw_exception_when_name_is_null() {
            assertThrows(
                    IllegalArgumentException.class,
                    () -> Inventory.getProduct(null)
            );
        }
    }
}