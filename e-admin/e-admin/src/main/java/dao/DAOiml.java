package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Order;



public class DAOiml implements DAO {

	
    public Map<String, String> getUserNameAndPassword() {
        Map<String, String> authData = new HashMap<>();
        String sql = "SELECT * FROM auth";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/ecommercedb";
            String un = "root";
            String pw = "";
            
            try (Connection con = DriverManager.getConnection(url, un, pw);
                 PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    String name = rs.getString("name");
                    String password = rs.getString("password");
                    authData.put(name, password);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Handle your exceptions properly
            System.out.print("not connect db");
        }
        return authData;
    }
    public List<Order> getOrders(){
		 List<Order> orderList = new ArrayList<>();

	        String sql = "SELECT * FROM orders"; // Corrected table name from "prodacts" to "products"
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            String url = "jdbc:mysql://127.0.0.1:3306/ecommercedb";
	            String un = "root";
	            String pw = "";
		        try (Connection con = DriverManager.getConnection(url, un, pw);
			             PreparedStatement ps = con.prepareStatement(sql)) {
		            try (ResultSet rs = ps.executeQuery()) {
		            	         
		            	while (rs.next()) {
		                    
		                    Order order = new Order();
		                    order.setId(rs.getInt("Id"));
		                    order.setPname(rs.getString("pname"));
		                    order.setPprice(rs.getString("pprice"));
		                    order.setPsize(rs.getString("psize"));
		                    order.setPcolor(rs.getString("pcolor"));
		                    order.setCname(rs.getString("cname"));
		                    order.setCaddress(rs.getString("caddress"));
		                    order.setCcity(rs.getString("ccity"));
		                    order.setCstate(rs.getString("cstate"));
		                    order.setCpin(rs.getString("cpin"));
		                    order.setCcountry(rs.getString("ccountry"));

		                    order.setImage(rs.getBytes("pimage"));
		                    // You may want to retrieve and set the image as well
		                    orderList.add(order);
		                    

		                    
		              
		                }
	}
		            }
		        	  
		        } catch (ClassNotFoundException | SQLException ex) {
			        ex.printStackTrace(); // Handle or log the exception as needed
			        System.out.print("not connect db *order*");
			    }return orderList;
	        }
    public boolean addProduct(String productName, String productPrice, String productDiscount, String productRating, byte[] productImage) {
        String sql = "INSERT INTO prodacts (prodactname, prodactprice, prodactdiscount, prodactrating, prodactimage) VALUES (?, ?, ?, ?, ?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/ecommercedb";
            String un = "root";
            String pw = "";
            try (Connection con = DriverManager.getConnection(url, un, pw);
                 PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, productName);
                ps.setString(2, productPrice);
                ps.setString(3, productDiscount);
                ps.setString(4, productRating);
                ps.setBytes(5, productImage);

                int rowsAffected = ps.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (Exception ex) {
            ex.printStackTrace(); // Handle or log the exception as needed
            System.out.print("not connectdb");
            return false;
            

        }
    }
    
    @Override
    public boolean delivered(int id) {
        String sql = "DELETE FROM orders WHERE Id = ?";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/ecommercedb";
            String un = "root";
            String pw = "";
            try (Connection con = DriverManager.getConnection(url, un, pw);
                 PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, id);

                int rowsAffected = ps.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace(); // Handle or log the exception as needed
            System.out.println("Failed to mark order as delivered in the database.");
            return false;
        }
    }


}
