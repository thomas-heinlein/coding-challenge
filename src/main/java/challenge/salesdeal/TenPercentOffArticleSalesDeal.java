package challenge.salesdeal;

import challenge.Inventory;
import challenge.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

public class TenPercentOffArticleSalesDeal implements SalesDeal {

    private final Product salesDealProduct;

    public TenPercentOffArticleSalesDeal(Product salesDealProduct) {
        this.salesDealProduct = salesDealProduct;
    }

    public TenPercentOffArticleSalesDeal(String salesDealProductName) {
        this.salesDealProduct = Inventory.getProduct(salesDealProductName);
    }

    @Override
    public BigDecimal getDiscount(List<Product> productsInBasket) {
        long numberOfOccurrences = productsInBasket.stream()
                .filter(p -> Objects.equals(p, salesDealProduct))
                .count();

        return BigDecimal.valueOf(numberOfOccurrences)
                .multiply(BigDecimal.valueOf(0.1))
                .multiply(salesDealProduct.price())
                .setScale(2, RoundingMode.HALF_UP);
    }
}
