import utils.*;

import java.io.Console;

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

    }
}
