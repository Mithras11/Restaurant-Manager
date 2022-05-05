package utils;

import java.math.BigDecimal;
import java.util.List;

import models.*;

public class DataProcessor {
    private List<FoodProduct> _foodProducts;
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
        var product = _foodProducts
                .stream()
                .filter(x -> x.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (product != null) {
            product.setPrice(product.getPrice().add(BigDecimal.ONE));
        }
    }
}
