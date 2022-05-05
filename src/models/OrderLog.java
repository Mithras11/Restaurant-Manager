package models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class OrderLog {
    private final int _orderNumber;
    private final LocalDate _date;


    private final Collection<ProductOrder> _productOrders;


    public OrderLog(
            int orderNumber, LocalDate date, Collection<ProductOrder> productOrders) {
        _orderNumber = orderNumber;
        _date = date;
        _productOrders = new ArrayList(productOrders);
    }

    public BigDecimal getTotalPrice() {
        return _productOrders.stream()
                .map(ProductOrder::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Collection<ProductOrder> getProductOrders() {
        return _productOrders;
    }

    public int getOrderNumber() {
        return _orderNumber;
    }
}
