package service;

import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Order;


@Service
public interface AdminSrvice {
	public boolean adminLogin(String loginUsername,String loginPassword);
	public List<Order> getOrders() ;
	public boolean addProduct(String productName, String productPrice, String productDiscount, String productRating, InputStream productImage);	
	public boolean updateProduct	(String productName, String productPrice, String productDiscount, String productRating, InputStream productImage); 
	public boolean delivered(int id);

}
