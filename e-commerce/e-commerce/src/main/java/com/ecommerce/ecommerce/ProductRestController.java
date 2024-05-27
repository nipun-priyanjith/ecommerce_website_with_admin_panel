package com.ecommerce.ecommerce;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.JavaDict;
import model.Product;
import service.ProductService;

@Controller
@RequestMapping("/ecommerce")
public class ProductRestController {
	
	@GetMapping("/home")
	public String getAllProducts(Model model) {
		ProductService pr =new ProductService();
	    List<Product> productList = pr.getAllProducts();
	    model.addAttribute("productList", productList);
	    return "home"; 
	}
	
	@GetMapping("/infinity")
	public String getAllINFProducts(Model model) {
		ProductService pr =new ProductService();
	    List<Product> productList = pr.getAllProducts();
	    model.addAttribute("productList", productList);
	    return "infinityprodacts"; 
	}
	
	
	

    
    

	@PostMapping("/card")
	public String addToCard(HttpServletRequest request, HttpSession session) {
	    int id = Integer.parseInt(request.getParameter("id"));
	    String productName = request.getParameter("productName");
	    String productPrice = request.getParameter("productPrice");
	    String productDiscount = request.getParameter("productDiscount");
	    String productRating = request.getParameter("productRating");
	    String productImage = request.getParameter("productImage");
	    String selectedSize = request.getParameter("size");
	    String selectedColor = request.getParameter("color");


	    Product product = new Product();
	    product.setId(id);
	    product.setName(productName);
	    product.setPrice(productPrice);
	    product.setDiscount(productDiscount);
	    product.setRating(productRating);
	    product.setImage(Base64.getDecoder().decode(productImage));
	    product.setSelectedSize(selectedSize);
	    product.setSelectedColor(selectedColor);

	    JavaDict productDict = (JavaDict) session.getAttribute("productDict");
	    if (productDict == null) {
	        productDict = new JavaDict();
	    }

	    productDict.create(String.valueOf(id), product);
	    session.setAttribute("productDict", productDict);

	    return "card"; 
	}
	
	@GetMapping("/card")
	public String viewCard(HttpSession session, Model model) {
	    JavaDict productDict = (JavaDict) session.getAttribute("productDict");
	    if (productDict == null) {
	        productDict = new JavaDict();
	    }
	    
	    session.setAttribute("productDict", productDict); 
	    
	    model.addAttribute("productDict", productDict); 
	    
	    return "card"; 
	}



    
    @PostMapping("/prodactinfo")
    public String handleProductInfo(@RequestParam("id") int productId,
                                    @RequestParam("productName") String productName,
                                    @RequestParam("productPrice") String productPrice,
                                    @RequestParam("productDiscount") String productDiscount,
                                    @RequestParam("productRating") String productRating,
                                    @RequestParam("productImage") String productImage,
                                    HttpSession session) {
        Product product = new Product();
        product.setId(productId);
        product.setName(productName);
        product.setPrice(productPrice);
        product.setDiscount(productDiscount);
        product.setRating(productRating);
        product.setImage(Base64.getDecoder().decode(productImage));

        session.setAttribute("product", product);
        return "prodactinfo"; 
    }


    @PostMapping("/orders")
    public String placeOrder(@RequestParam("name") String fname,
                           @RequestParam("address") String address,
                           @RequestParam("city") String city,
                           @RequestParam("state") String state,
                           @RequestParam("zip") String zip,
                           @RequestParam("country") String country,
                           HttpSession session) {
        JavaDict productDict = (JavaDict) session.getAttribute("productDict");
        if (productDict != null) {
            for (Map.Entry<String, Object> entry : productDict.readAll().entrySet()) {
                Product product = (Product) entry.getValue();
                ProductService  productService = new ProductService ();
                productService.addOrder(product.getId(), product.getName(), product.getPrice(),
                        product.getSelectedSize(), product.getSelectedColor(), product.getImage(),
                        fname, address, city, state, zip, country);
                System.out.print("***************************************************************");
                System.out.print(product.getName());
            }
            session.setAttribute("productDict", null);
            
        } return "redirect:/ecommerce/home";
    }

    @PostMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") String productId, HttpSession session) {
        JavaDict productDict = (JavaDict) session.getAttribute("productDict");
        if (productDict != null) {
            productDict.delete(productId);
            session.setAttribute("productDict", productDict);
        }
      
        return "redirect:/ecommerce/card"; 
    }

    @ExceptionHandler
    public void handleException(Exception e, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }
}