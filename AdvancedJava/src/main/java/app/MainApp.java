package app;

import dao.ProductDAO;
import model.Product;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductDAO dao = new ProductDAO();

        while(true){

            System.out.println("===== PRODUCT INVENTORY MENU =====");

            System.out.println("1 Add Product");
            System.out.println("2 View All Products");
            System.out.println("3 Exit");

            int choice = sc.nextInt();

            switch(choice){

                case 1:

                    System.out.println("Enter Product ID");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter Product Name");
                    String name = sc.nextLine();

                    System.out.println("Enter Category");
                    String category = sc.nextLine();

                    System.out.println("Enter Price");
                    double price = sc.nextDouble();

                    System.out.println("Enter Quantity");
                    int quantity = sc.nextInt();

                    System.out.println("Enter Rating");
                    double rating = sc.nextDouble();

                    Product p = new Product(id,name,category,price,quantity,rating);

                    dao.addProduct(p);

                    break;

                case 2:

                    dao.viewAllProducts();

                    break;

                case 3:

                    System.out.println("Exiting...");
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }
}