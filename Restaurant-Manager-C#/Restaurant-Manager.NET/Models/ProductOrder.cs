namespace CollectionsLinq.Models
{
    public class ProductOrder
    {
        public ProductOrder(FoodProduct product, int quantity)
        {
            this.Product = product;
            this.Quantity = quantity;
            this.TotalPrice = product.Price * quantity;
        }

        public FoodProduct Product { get; }

        public int Quantity { get; }

        public decimal TotalPrice { get; }
    }
}
