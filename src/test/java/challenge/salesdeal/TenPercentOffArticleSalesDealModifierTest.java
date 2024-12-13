package challenge.salesdeal;

import challenge.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TenPercentOffArticleSalesDealModifierTest {

    Product PRODUCT = Product.of("some product", 1.0);
    Product OTHER_PRODUCT = Product.of("some other product", 2.0);

    TenPercentOffArticleSalesDeal cut = new TenPercentOffArticleSalesDeal(PRODUCT);

    @Test
    void return_10_percent_of_product_if_it_occurs_once() {
        BigDecimal discount = cut.getDiscount(List.of(PRODUCT));

        assertThat(discount).isEqualByComparingTo(BigDecimal.valueOf(0.1));
    }

    @Test
    void return_2_times_10_percent_of_product_if_it_occurs_twice() {
        BigDecimal discount = cut.getDiscount(List.of(PRODUCT, PRODUCT));

        assertThat(discount).isEqualByComparingTo(BigDecimal.valueOf(0.2));
    }

    @Test
    void return_0_if_product_does_not_occur() {
        BigDecimal discount = cut.getDiscount(List.of(OTHER_PRODUCT));

        assertThat(discount).isEqualByComparingTo(BigDecimal.ZERO);
    }
}