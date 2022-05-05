package models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class OrderLog {
    private int _orderNumber;
    private LocalDate _date;
    private Collection<ProductOrder> _productOrders;

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
}
