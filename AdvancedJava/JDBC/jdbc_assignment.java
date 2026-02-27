package org.example;

import java.sql.*;
import java.util.Scanner;

public class App {

    static final String URL = "jdbc:mysql://localhost:3306/student";
    static final String USER = "root";
    static final String PASSWORD = "123456";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {

            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Update Price");
            System.out.println("4. Update Stock");
            System.out.println("5. Delete Product");

            int choice = sc.nextInt();

            switch (choice) {


                case 1: {
                    sc.nextLine();

                    System.out.println("Enter product id:");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter name:");
                    String name = sc.nextLine();

                    System.out.println("Enter category:");
                    String category = sc.nextLine();

                    System.out.println("Enter price:");
                    double price = sc.nextDouble();

                    System.out.println("Enter quantity:");
                    int quantity = sc.nextInt();

                    System.out.println("Enter rating:");
                    double rating = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("Enter manufacturer:");
                    String manufacturer = sc.nextLine();
                    String sql = "INSERT INTO products " +
                            "(product_id, product_name, category, price, quantity, rating, manufacturer) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?)";

                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setInt(1, id);
                    ps.setString(2, name);
                    ps.setString(3, category);
                    ps.setDouble(4, price);
                    ps.setInt(5, quantity);
                    ps.setDouble(6, rating);
                    ps.setString(7, manufacturer);

                    int rows = ps.executeUpdate();
                    System.out.println("Inserted: " + rows);
                    break;
                }

                // ✅ 2. VIEW PRODUCTS
                case 2: {
                    String sql = "SELECT * FROM products";
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) {
                        System.out.println(
                                rs.getInt("product_id") + " | " +
                                        rs.getString("product_name") + " | " +
                                        rs.getString("category") + " | " +
                                        rs.getDouble("price") + " | " +
                                        rs.getInt("quantity") + " | " +
                                        rs.getDouble("rating") + " | " +
                                        rs.getString("manufacturer")
                        );
                    }
                    break;
                }


                case 3: {
                    System.out.println("Enter product id:");
                    int id = sc.nextInt();

                    System.out.println("Enter new price:");
                    double price = sc.nextDouble();

                    String sql = "UPDATE products SET price = ? WHERE product_id = ?";
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setDouble(1, price);
                    ps.setInt(2, id);

                    int rows = ps.executeUpdate();
                    System.out.println("Updated: " + rows);
                    break;
                }


                case 4: {
                    System.out.println("Enter product id:");
                    int id = sc.nextInt();

                    System.out.println("1. Increase  2. Decrease");
                    int option = sc.nextInt();

                    System.out.println("Enter quantity:");
                    int qty = sc.nextInt();

                    String sql;

                    if (option == 1) {
                        sql = "UPDATE products SET quantity = quantity + ? WHERE product_id = ?";
                    } else {
                        sql = "UPDATE products SET quantity = quantity - ? WHERE product_id = ?";
                    }

                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setInt(1, qty);
                    ps.setInt(2, id);

                    int rows = ps.executeUpdate();
                    System.out.println("Stock Updated: " + rows);
                    break;
                }

                case 5: {
                    System.out.println("Enter product id:");
                    int id = sc.nextInt();

                    String sql = "DELETE FROM products WHERE product_id = ?";
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setInt(1, id);

                    int rows = ps.executeUpdate();
                    System.out.println("Deleted: " + rows);
                    break;
                }

                default:
                    System.out.println("Invalid Choice");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
