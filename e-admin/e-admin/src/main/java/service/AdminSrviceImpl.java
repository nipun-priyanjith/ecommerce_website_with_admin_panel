package service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import dao.DAOiml;
import model.Order;
@Service
public class AdminSrviceImpl implements AdminSrvice {
	DAOiml bb =new DAOiml();

	@Override
	public boolean adminLogin(String loginUsername, String loginPassword) {
		System.out.print("#################");
        Map<String, String> authData = bb.getUserNameAndPassword();
        
        // Check if the username exists in the database
        if (authData.containsKey(loginUsername)) {
            // Check if the password matches
            if (authData.get(loginUsername).equals(loginPassword)) {
                return true; // Username and password match
            }
        }
        return false; 
	}

	@Override
	public List<Order> getOrders() {
		DAOiml orders =new DAOiml();
        List<Order> productList = orders.getOrders();
        return productList;
	}

	@Override
	public boolean addProduct(String productName, String productPrice, String productDiscount, String productRating,
			InputStream productImage) {
		byte[] imageBytes = null;
        try {
            // Read all bytes from the input stream
            imageBytes = productImage.readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("not convert image");

            return false; // Return false in case of error
        }
        // Call the DAO method to add the product
        DAOiml dao = new DAOiml();
        System.out.println(productName);
        System.out.println(productPrice);
        System.out.println(productDiscount);
        System.out.println(productRating);
        return dao.addProduct(productName, productPrice, productDiscount, productRating, imageBytes);
	}
	
	@Override
	public boolean updateProduct(String productName, String productPrice, String productDiscount, String productRating,
			InputStream productImage) {
		byte[] imageBytes = null;
        try {
            // Read all bytes from the input stream
            imageBytes = productImage.readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("not convert image");

            return false; // Return false in case of error
        }
        // Call the DAO method to add the product
        DAOiml dao = new DAOiml();
        System.out.println(productName);
        System.out.println(productPrice);
        System.out.println(productDiscount);
        System.out.println(productRating);
        return dao.addProduct(productName, productPrice, productDiscount, productRating, imageBytes);
	}
	@Override
	public boolean delivered(int id) {System.out.print("servissss");System.out.print(id); bb.delivered(id);  return true;}

}
