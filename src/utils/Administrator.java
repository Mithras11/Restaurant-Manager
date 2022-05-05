package utils;

import java.math.BigDecimal;
import java.util.*;

import models.FoodProduct;

public class Administrator {
    public static List<FoodProduct> populateFoodProducts() {
        return Arrays.asList(
                new FoodProduct(
                        1, "Chicken with rice", "meat",
                        null, "fried",
                        new BigDecimal(12), true,
                        Arrays.asList("Chicken meat", "Rice", "Spices")),

                new FoodProduct(
                        2, "Pork with cabbage", "meat",
                        null, "boiled",
                        new BigDecimal(15), true,
                        Arrays.asList("Pork meat", "Cabbage", "Spices")),

                new FoodProduct(
                        3, "Spinach soup", "vegetables",
                        null, "boiled",
                        new BigDecimal(8), true,
                        Arrays.asList("Spinach", "Cheese", "Spices")),

                new FoodProduct(
                        4, "Tomato soup", "vegetables",
                        null, "boiled",
                        new BigDecimal(9), false,
                        Arrays.asList("Tomato", "Spices")),

                new FoodProduct(
                        5, "Coca-Cola", "soft drink",
                        null, "no sugar",
                        new BigDecimal(2), false,
                        Arrays.asList("water", "magic")),

                new FoodProduct(
                        6, "Spaghetti Bolognese", "pasta",
                        null, "boiled",
                        new BigDecimal(11), false,
                        Arrays.asList("Spaghetti", "Tomato sauce", "Meat"))
        );
    }
}
