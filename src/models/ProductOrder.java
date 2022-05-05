package models;

import java.math.BigDecimal;

public class ProductOrder {
    private  FoodProduct _product;
    private  int _quantity;
    private BigDecimal _totalPrice;

    public ProductOrder(FoodProduct product, int quantity)
    {
        _product = product;
        _quantity = quantity;
        _totalPrice = product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

    public FoodProduct getProduct() {
        return _product;
    }

    public void setProduct(FoodProduct _product) {
        this._product = _product;
    }

    public int getQuantity() {
        return _quantity;
    }

    public void setQuantity(int _quantity) {
        this._quantity = _quantity;
    }

    public BigDecimal getTotalPrice() {
        return _totalPrice;
    }

    public void setTotalPrice(BigDecimal _totalPrice) {
        this._totalPrice = _totalPrice;
    }
}
