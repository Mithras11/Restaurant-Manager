import utils.*;

import java.io.Console;

public class Client {
    public static void main(String[] args) {
        //populate products list
        var foodProducts = Administrator.populateFoodProducts();
        var ordersHistory = Playwright.createRandomOrderHistory(foodProducts);
        var dataProcessor = new DataProcessor(foodProducts, ordersHistory);

//------------------------------------------------------------------------------------------
//queries
//1. Food products list - select all enabled products
        System.out.println("1. Food products list - select all enabled products");
    }
}
