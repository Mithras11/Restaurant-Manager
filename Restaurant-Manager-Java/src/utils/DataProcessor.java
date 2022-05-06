package utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;
import java.util.*;

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
                .filter(x -> x.getName().toLowerCase()
                        .startsWith(productName.toLowerCase()))
                .findFirst()
                .orElse(null);
    }

    public void updatePrice(String name) {
        _foodProducts
                .stream()
                .filter(x -> x.getName().equalsIgnoreCase(name))
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
                .filter(p -> p.getName().toLowerCase()
                        .contains(wildcard.toLowerCase()))
                .forEach(p -> _sb.append(String.format("%s\n", p.getName())));

        var result = _sb.toString();
        _sb.setLength(0);
        return result;
    }

    public String getProductsWithRice() {
        _foodProducts
                .stream()      //Contains operator for collections is case-insensitive by default
                .filter(p -> p.getIngredients().contains("Rice"))
                .forEach(p -> _sb.append(String.format("%s\n", p.getName())));

        var result = _sb.toString();
        _sb.setLength(0);
        return result;
    }

    public String searchOrdersByProduct(String productName) {
        _ordersHistory
                .stream()
                .filter(o -> o.getProductOrders()
                        .stream()
                        .anyMatch(po -> po.getProduct().getName()
                                .equalsIgnoreCase(productName)))
                .forEach(o -> _sb.append(String.format(
                        "Order number - %s, Total price - $%.2f\n",
                        o.getOrderNumber(), o.getTotalPrice().doubleValue())));

        var result = _sb.toString();
        _sb.setLength(0);
        return result;
    }

    public String searchByOrderNumber(int orderNumber) {
        var result = _ordersHistory
                .stream()
                .filter(o -> o.getOrderNumber() == orderNumber)
                .reduce(_sb, (acc, o) -> {
                            o.getProductOrders()
                                    .forEach(po -> acc.append(String.format("%s - $%s\n",
                                            po.getProduct().getName(),
                                            po.getProduct().getPrice().doubleValue())));
                            return acc;
                        },
                        StringBuilder::append)
                .toString();

        _sb.setLength(0);
        return result;
    }

    public String searchOrdersByPeriod(LocalDate startDate, LocalDate endDate) {
        var result = _ordersHistory
                .stream()
                .filter(o -> (o.getDate().isAfter(startDate) || o.getDate().isEqual(startDate)) &&
                        (o.getDate().isBefore(endDate) || o.getDate().isEqual(endDate)))
                .sorted(Comparator.comparing(OrderLog::getDate))
                .reduce(_sb, (acc, o) -> {
                            o.getProductOrders()
                                    .forEach(po -> acc.append(String.format("%s - %s\n",
                                            po.getProduct().getName(),
                                            o.getDate())));
                            return acc;
                        },
                        StringBuilder::append)
                .toString();

        _sb.setLength(0);
        return result;
    }

    public String searchProductsForLastMonth(LocalDate startDate, LocalDate endDate) {
        var allProducts = _ordersHistory
                .stream()
                .filter(o -> (o.getDate().isAfter(startDate) || o.getDate().isEqual(startDate)) &&
                        (o.getDate().isBefore(endDate) || o.getDate().isEqual(endDate)))
                .flatMap(o -> o.getProductOrders()
                        .stream()
                        .map(po -> {
                            record productStats(String productName, BigDecimal totalPrice, Integer quantity) {
                            }
                            return new productStats(
                                    po.getProduct().getName(),
                                    po.getTotalPrice(),
                                    po.getQuantity());
                        }))
                .collect(Collectors.groupingBy(x -> x.productName,
                        TreeMap::new, Collectors.toList()));

        for (var key : allProducts.keySet()) {
            var productCount = allProducts.get(key).stream()
                    .mapToInt(x -> x.quantity).sum();
            var endPrice = allProducts.get(key).stream()
                    .mapToDouble(x -> x.totalPrice.doubleValue()).sum();

            _sb.append(String.format("Product name: %s, ", key));
            _sb.append(String.format("Product count: %d, ", productCount));
            _sb.append(String.format("Total price: $%.2f\n", endPrice));
        }

        var result = _sb.toString();
        _sb.setLength(0);
        return result;
    }

    public Double searchAverageOrdersForLastMonth(LocalDate startDate, LocalDate endDate) {
        var allOrders = _ordersHistory
                .stream()
                .filter(o -> (o.getDate().isAfter(startDate) || o.getDate().isEqual(startDate))
                        && o.getDate().isBefore(endDate))
                .collect(Collectors.groupingBy(OrderLog::getDate, Collectors.toList()));

        var totalDays = ChronoUnit.DAYS.between(startDate, endDate);
        var ordersTotalCount = allOrders.values().stream()
                .mapToInt(List::size).sum();

        return ordersTotalCount * 1.0 / totalDays;
    }

    public String getTotalOrderAmountPerMonth(LocalDate startDate, LocalDate endDate) {
        var allOrders = _ordersHistory
                .stream()
                .filter(o -> (o.getDate().isAfter(startDate) || o.getDate().isEqual(startDate))
                        && o.getDate().isBefore(endDate))
                .collect(Collectors.groupingBy(OrderLog::getDate,
                        TreeMap::new, Collectors.toList()));

        for (var key : allOrders.keySet()) {
            _sb.append(String.format("Day of month: %td - Amount of orders: %d\n",
                    key, allOrders.get(key).size()));
        }

        var result = _sb.toString();
        _sb.setLength(0);
        return result;
    }
}
