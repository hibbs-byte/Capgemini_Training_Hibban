package model;

public class Product {

    private int productId;
    private String name;
    private String category;
    private double price;
    private int quantity;
    private double rating;

    public Product(int productId, String name, String category,
                   double price, int quantity, double rating) {

        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.rating = rating;
    }

    public int getProductId() { return productId; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public double getRating() { return rating; }
}