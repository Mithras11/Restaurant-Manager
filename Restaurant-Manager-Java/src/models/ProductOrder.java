package models;

import java.math.BigDecimal;

public class ProductOrder {
    private final FoodProduct _product;
    private final int _quantity;
    private final BigDecimal _totalPrice;

    public ProductOrder(FoodProduct product, int quantity) {
        _product = product;
        _quantity = quantity;
        _totalPrice = product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

    public FoodProduct getProduct() {
        return _product;
    }

    public int getQuantity() {
        return _quantity;
    }

    public BigDecimal getTotalPrice() {
        return _totalPrice;
    }
}
