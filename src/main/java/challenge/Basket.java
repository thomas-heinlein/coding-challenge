package challenge;

import challenge.salesdeal.SalesDeal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Basket {

    private final List<Product> scannedProducts = new ArrayList<>();
    private final List<SalesDeal> salesDeals;

    public Basket(SalesDeal... salesDeals) {
        this.salesDeals = Arrays.stream(salesDeals).toList();
    }

    public void scan(String name) {
        Product product = Inventory.getProduct(name);
        scannedProducts.add(product);
    }

    public BigDecimal getTotal() {
        BigDecimal subTotal = getTotalProductPrices();
        List<Product> unmodifiableScannedProducts = Collections.unmodifiableList(scannedProducts);
        BigDecimal discount = getDiscount(unmodifiableScannedProducts);

        return subTotal.subtract(discount);
    }

    private BigDecimal getTotalProductPrices() {
        return scannedProducts.stream()
                .map(Product::price)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal getDiscount(List<Product> products) {
        return salesDeals.stream()
                .map(salesDeal -> salesDeal.getDiscount(products))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<Product> getScannedProducts() {
        return Collections.unmodifiableList(scannedProducts);
    }

}
