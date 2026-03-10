package dao;

import model.Product;
import util.DBConnection;

import java.sql.*;

public class ProductDAO {

    public void addProduct(Product p) {

        String sql = "INSERT INTO products VALUES (?,?,?,?,?,?,NOW())";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, p.getProductId());
            ps.setString(2, p.getName());
            ps.setString(3, p.getCategory());
            ps.setDouble(4, p.getPrice());
            ps.setInt(5, p.getQuantity());
            ps.setDouble(6, p.getRating());

            ps.executeUpdate();

            System.out.println("Product Added Successfully");

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void viewAllProducts() {

        String sql = "SELECT * FROM products";

        try(Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql)) {

            while(rs.next()) {

                System.out.println(
                        rs.getInt("product_id") + " " +
                                rs.getString("product_name") + " " +
                                rs.getString("category") + " " +
                                rs.getDouble("price") + " " +
                                rs.getInt("quantity") + " " +
                                rs.getDouble("rating")
                );
            }

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}