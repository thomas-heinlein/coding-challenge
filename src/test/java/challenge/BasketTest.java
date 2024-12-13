package challenge;

import challenge.salesdeal.TenPercentOffArticleSalesDeal;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BasketTest {

    Product PRODUCT = Inventory.getInventory().getFirst();

    @Test
    void can_scan() {
        Basket cut = new Basket();

        cut.scan(PRODUCT.name());

        assertThat(cut.getScannedProducts()).containsExactly(PRODUCT);
    }

    @Test
    void can_return_total() {
        Basket cut = new Basket();
        Product otherProduct = Inventory.getInventory().get(1);
        cut.scan(PRODUCT.name());
        cut.scan(otherProduct.name());

        BigDecimal total = cut.getTotal();

        BigDecimal expectedTotal = PRODUCT.price().add(otherProduct.price());
        assertThat(total).isEqualByComparingTo(expectedTotal);
    }

    @Test
    void can_apply_modifier() {
        TenPercentOffArticleSalesDeal modifier = new TenPercentOffArticleSalesDeal(PRODUCT);
        Basket cut = new Basket(modifier);
        cut.scan(PRODUCT.name());

        BigDecimal total = cut.getTotal();

        BigDecimal expectedDiscount = modifier.getDiscount(List.of(PRODUCT));
        BigDecimal expectedTotal = PRODUCT.price().subtract(expectedDiscount);
        assertThat(total).isEqualByComparingTo(expectedTotal);
    }

}