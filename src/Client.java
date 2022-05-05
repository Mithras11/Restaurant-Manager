import utils.*;

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
    }
}
