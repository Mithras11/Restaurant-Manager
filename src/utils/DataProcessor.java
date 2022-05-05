package utils;

import java.math.BigDecimal;
import java.util.List;

import models.*;

public class DataProcessor {
    private final List<FoodProduct> _foodProducts;
    private List<OrderLog> _ordersHistory;
    private StringBuilder _sb;

    public DataProcessor(List<FoodProduct> foodProducts) {
        _foodProducts = foodProducts;
    }

    public DataProcessor(List<FoodProduct> foodProducts, List<OrderLog> ordersHistory) {
        _foodProducts = foodProducts;
        _ordersHistory = ordersHistory;
        _sb = new StringBuilder();
    }

    public FoodProduct findProductByName(String productName) {
        return _foodProducts
                .stream()
                .filter(x -> x.getName().startsWith(productName))
                .findFirst()
                .orElse(null);
    }

    public void updatePrice(String name) {
        _foodProducts
                .stream()
                .filter(x -> x.getName().equals(name))
                .findFirst()
                .ifPresent(product
                        -> product.setPrice(product.getPrice()
                        .add(BigDecimal.ONE)));
    }

    public String getEnabledProducts() {
        _foodProducts
                .stream()
                .filter(FoodProduct::getIsEnabled)
                .forEach(p -> _sb.append(String.format("%s  - isEnabled = %b\n",
                        p.getName(), p.getIsEnabled())));

        var result = _sb.toString();
        _sb.setLength(0);
        return result;
    }

    public String getProductByPartOfName(String wildcard) {
        _foodProducts
                .stream()
                .filter(p -> p.getName().contains(wildcard))
                .forEach(p -> _sb.append(String.format("%s\n", p.getName())));

        var result = _sb.toString();
        _sb.setLength(0);
        return result;
    }

    public String getProductsWithRice() {
        _foodProducts
                .stream()
                .filter(p -> p.getIngredients().contains("Rice"))
                .forEach(p -> _sb.append(String.format("%s\n", p.getName())));

        var result = _sb.toString();
        _sb.setLength(0);
        return result;
    }
}
