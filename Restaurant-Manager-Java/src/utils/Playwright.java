package utils;

import java.time.LocalDate;
import java.util.*;

import models.*;

public class Playwright {
    public static List<OrderLog> createRandomOrderHistory(List<FoodProduct> foodProducts) {
        var dataProcessor = new DataProcessor(foodProducts);

        var orderedChicken = dataProcessor.findProductByName("Chicken");
        var orderedSpinachSoup = dataProcessor.findProductByName("Spinach");
        var orderedCocaCola = dataProcessor.findProductByName("Coca");

        var firstOrder = new OrderLog(
                1, LocalDate.of(2022, 02, 15),
                Arrays.asList(
                        new ProductOrder(orderedChicken, 2),
                        new ProductOrder(orderedSpinachSoup, 1)
                ));

        var secondOrder = new OrderLog(
                2, LocalDate.of(2022, 02, 15),
                Arrays.asList(
                        new ProductOrder(orderedCocaCola, 1)
                ));

        var ordersHistory = new ArrayList<>(Arrays.asList(firstOrder, secondOrder));

        //change coca-cola price and add new order
        dataProcessor.updatePrice("Coca-Cola");

        var cocaColaWithNewPrice = dataProcessor.findProductByName("Coca");
        var thirdOrder = new OrderLog(
                3, LocalDate.of(2022, 02, 16),
                Arrays.asList(
                        new ProductOrder(cocaColaWithNewPrice, 1)
                ));

        ordersHistory.add(thirdOrder);

        //change coca-cola price one more time and add order
        dataProcessor.updatePrice("Coca-Cola");

        var cocaColaWithThirdPrice = dataProcessor.findProductByName("Coca");
        var fourthOrder = new OrderLog(
                4, LocalDate.of(2022, 02, 23),
                Arrays.asList(
                        new ProductOrder(cocaColaWithThirdPrice, 1)
                ));

        ordersHistory.add(fourthOrder);
        return ordersHistory;
    }
}
