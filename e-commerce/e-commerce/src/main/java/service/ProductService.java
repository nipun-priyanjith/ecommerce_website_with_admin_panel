package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Product;
@Service
public class ProductService {
    public List<Product> getAllProducts() {
        System.out.println("hhhhhhhhhhhhhhhhhhhhhhhh");
        List<Product> productList = new ArrayList<>();

        String sql = "SELECT * FROM prodacts"; // Corrected table name from "prodacts" to "products"
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/ecommercedb";
            String un = "root";
            String pw = "";
	        try (Connection con = DriverManager.getConnection(url, un, pw);
		             PreparedStatement ps = con.prepareStatement(sql)) {
	            try (ResultSet rs = ps.executeQuery()) {
	            	         
	            	while (rs.next()) {
	                    System.out.println("yyyyyyyyyyyyyyyy");
	                    Product product = new Product();
	                    product.setId(rs.getInt("prodactid"));
	                    product.setName(rs.getString("prodactname"));
	                    product.setPrice(rs.getString("prodactprice"));
	                    product.setDiscount(rs.getString("prodactdiscount"));
	                    product.setRating(rs.getString("prodactrating"));
	                    product.setImage(rs.getBytes("prodactimage"));
	                    // You may want to retrieve and set the image as well
	                    productList.add(product);
	                    System.out.println("hhhhhhhhhhhhhhhhhhhhhhhh");
	                    System.out.println(product.getName());
	                    System.out.println(product.getId());
	                    System.out.println(product.getPrice());
	                    System.out.println(product.getRating());
	                    
	              
	                }
}
	            }
	        	  
	        } catch (ClassNotFoundException | SQLException ex) {
		        ex.printStackTrace(); // Handle or log the exception as needed
		    }
        return productList;
    }
    public void addOrder(int id, String name, String price, String size, String color, byte[] image, String fname, String address, String city, String state, String pin, String country) {
    	System.out.print(name);
    	System.out.print("#############################################################");
    	System.out.print(name);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/ecommercedb";
            String un = "root";
            String pw = "";

            try (Connection con = DriverManager.getConnection(url, un, pw)) {
                String sql = "INSERT INTO orders (Id, pname, pprice, psize, pcolor, pimage, cname, caddress, ccity, cstate, cpin, ccountry) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement ps = con.prepareStatement(sql)) {
                    ps.setInt(1, id);
                    ps.setString(2, name);
                    ps.setString(3, price);
                    ps.setString(4, size);
                    ps.setString(5, color);
                    ps.setBytes(6, image);
                    ps.setString(7, fname);
                    ps.setString(8, address);
                    ps.setString(9, city);
                    ps.setString(10, state);
                    ps.setString(11, pin);
                    ps.setString(12, country);

                    // Execute the insert statement
                    ps.executeUpdate();
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace(); // Handle or log the exception as needed
        }
    }

}
