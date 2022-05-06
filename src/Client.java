import utils.*;

import java.time.*;

public class Client {
    public static void main(String[] args) {
//0. Populate products list
        var foodProducts = Administrator.populateFoodProducts();
        var ordersHistory = Playwright.createRandomOrderHistory(foodProducts);
        var dataProcessor = new DataProcessor(foodProducts, ordersHistory);

//------------------------------------------------------------------------------------------
//queries
//1. Food products list - select all enabled products
        System.out.println("1. Food products list - select all enabled products");
        var enabledProducts = dataProcessor.getEnabledProducts();
        System.out.println(enabledProducts);
        System.out.println("===============");

//2. Search by part of a product  name ("%to%")
        System.out.println("2. Search by part of a product  name");
        var matchingProducts = dataProcessor.getProductByPartOfName("to");
        System.out.println(matchingProducts);
        System.out.println("===============");

//3. Search all products which contain ingredient rice
        System.out.println("3. Search all products which contain ingredient rice");
        var productsWithRice = dataProcessor.getProductsWithRice();
        System.out.println(productsWithRice);
        System.out.println("===============");

//4. Search orders by product
        System.out.println("4. Search orders by product");
        var ordersByProduct = dataProcessor.searchOrdersByProduct("Coca-Cola");
        System.out.println(ordersByProduct);
        System.out.println("===============");

//5. Search by order number
        System.out.println("5. Search by order number");
        var ordersByNumber = dataProcessor.searchByOrderNumber(1);
        System.out.println(ordersByNumber);
        System.out.println("===============");

//6. Search sold products during a period
        System.out.println("6. Search sold products during a period");
        var ordersByPeriod = dataProcessor.searchOrdersByPeriod(
                LocalDate.of(2022, Month.FEBRUARY, 15),
                LocalDate.of(2022, Month.FEBRUARY, 17));
        System.out.println(ordersByPeriod);
        System.out.println("===============");

//7. Search sold products for the last month
        System.out.println("7. Search sold products for the last month");
        var allProducts = dataProcessor.searchProductsForLastMonth(
                LocalDate.of(2022, Month.FEBRUARY, 15),
                LocalDate.of(2022, Month.FEBRUARY, 28));
        System.out.println(allProducts);
        System.out.println("===============");

//8. Search average orders amount for the last month
        System.out.println("8. Search average orders amount for the last month");
        var averageOrderAmount = dataProcessor.searchAverageOrdersForLastMonth(
                LocalDate.of(2022, Month.FEBRUARY, 1),
                LocalDate.of(2022, Month.MARCH, 1));
        System.out.printf("Average orders amount per day: %.2f\n", averageOrderAmount);
        System.out.println("===============");

//9. Search total orders amount per day for the last month

        System.out.println("9. Search total orders amount per day for the last month");
        var totalAmount = dataProcessor.getTotalOrderAmountPerMonth(
                LocalDate.of(2022, Month.FEBRUARY, 1),
                LocalDate.of(2022, Month.MARCH, 1));
        System.out.println(totalAmount);
    }
}
