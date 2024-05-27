package dao;

import java.util.List;
import java.util.Map;

import model.Order;

public interface DAO {
    public Map<String, String> getUserNameAndPassword();
    public List<Order> getOrders();
    public boolean addProduct(String productName, String productPrice, String productDiscount, String productRating, byte[] productImage);
    public boolean delivered(int id);
}
