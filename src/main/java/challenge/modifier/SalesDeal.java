package challenge.modifier;

import challenge.Product;

import java.math.BigDecimal;
import java.util.List;

public interface SalesDeal {
    BigDecimal getDiscount(List<Product> productsInBasket);
}
