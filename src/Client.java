import utils.*;

public class Client {
    public static void main(String[] args) {
        //populate products list
        var foodProducts = Administrator.populateFoodProducts();
        var ordersHistory = Playwright.createRandomOrderHistory(foodProducts);
        var dataProcessor = new DataProcessor(foodProducts, ordersHistory);
    }
}
