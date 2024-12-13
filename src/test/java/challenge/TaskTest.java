package challenge;

import challenge.modifier.TenPercentOffArticleSalesDeal;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class TaskTest {

    @Test
    void scan_item_and_get_total() {
        Basket basket = new Basket();

        basket.scan("A0001");

        assertThat(basket.getTotal()).isEqualTo(BigDecimal.valueOf(12.99));
    }

    @Test
    void give_10_percent_off_article_A0001() {
        Basket basket = new Basket(new TenPercentOffArticleSalesDeal("A0001"));

        basket.scan("A0002");
        basket.scan("A0001");
        basket.scan("A0002");

        assertThat(basket.getTotal()).isEqualByComparingTo(BigDecimal.valueOf(19.67));
    }
}
