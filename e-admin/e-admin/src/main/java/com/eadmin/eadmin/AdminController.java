package com.eadmin.eadmin;


import model.Order;
import service.AdminSrvice;
import service.AdminSrviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

	
	
    @Autowired
    private final AdminSrvice adminService;
    
  //  private boolean authenticateUsers = false;

    public AdminController(AdminSrviceImpl adminService) {
        this.adminService = adminService;

    }


    @GetMapping("/login")
    public String showLoginPage() {
        return "Login"; 
    }
    
    
    
    
    
    
    @PostMapping("/delivered/{id}")
    public String markOrderAsDelivered(@PathVariable("id") int orderId) {
        
    	
    	boolean stats= adminService.delivered(orderId);
    	return "redirect:/admin/home";
        
 
    }

    
    
    
    
    
    @PostMapping("/deletss")
    public String deleteResource() {

        return "Login";
    }

    

    
    
    

    @GetMapping("/home")
    public String showHomePage(Model model, HttpSession session) {
        if (isLoggedIn(session)) {
            List<Order> orderList = adminService.getOrders();
            model.addAttribute("orderList", orderList);
            return "home"; 
        } else {
            
            return "redirect:/admin/login";
        }
    }

    @PostMapping("/logins")
    public String login(String username, String password, Model model, HttpSession session) {
        boolean isAuthenticated = adminService.adminLogin(username, password);
        if (isAuthenticated) {
           
            session.setAttribute("loggedIn", true);
            return "redirect:/admin/home";
        } else {
            model.addAttribute("errorMessage", "Invalid username or password");
            return "redirect:/admin/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        
        session.invalidate();
        return "redirect:/admin/login";
    }

    @GetMapping("/new")
    public String showNewProductPage(HttpSession session) {
        if (isLoggedIn(session)) {
            return "NewProduct"; 
        } else {
            return "redirect:/admin/login";
        }
    }

   
    @PutMapping("/update")
    public String showUpdatePage(HttpSession session) {
        if (isLoggedIn(session)) {
            return "Update"; 
        } else {
            return "redirect:/admin/login";
        }
    }
    @DeleteMapping("/delete")
    public String showdeletePage() {
        
            return "Loginss broooooo"; 

    }
    
    @PutMapping("/updates")
    public ResponseEntity<String> updateProduct(@RequestParam String productName,
                                                 @RequestParam String productPrice,
                                                 @RequestParam String productDiscount,
                                                 @RequestParam String productRating,
                                                 @RequestParam("file") MultipartFile file,
                                                 HttpSession session) {
        if (isLoggedIn(session)) {
            try {
                boolean productUpdated = adminService.updateProduct(productName, productPrice, productDiscount, productRating, file.getInputStream());
                if (productUpdated) {
                    return ResponseEntity.ok("Product updated successfully");
                } else {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update product");
                }
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update product");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not logged in");
        }
    }

    @GetMapping("/users")
    public String showUsersPage(HttpSession session) {
        if (isLoggedIn(session)) {
            return "Users"; 
        } else {
            return "redirect:/admin/login";
        }
    }

    @GetMapping("/reviews")
    public String showReviewsPage(HttpSession session) {
        if (isLoggedIn(session)) {
            return "Reviews"; 
        } else {
            return "redirect:/admin/login";
        }
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam("productName") String productName,
                             @RequestParam("productPrice") String productPrice,
                             @RequestParam("productDiscount") String productDiscount,
                             @RequestParam("productRating") String productRating,
                             @RequestParam("file") MultipartFile file,
                             HttpSession session) {
        if (isLoggedIn(session)) {
            
            if (productName != null && !productName.isEmpty() &&
                productPrice != null && !productPrice.isEmpty()) {
                try {
                    
                    boolean productAdded = adminService.addProduct(productName, productPrice, productDiscount, productRating, file.getInputStream());

                    
                    if (productAdded) {
                        
                        return "redirect:/admin/home";
                    } else {
                    
                        return "redirect:/admin/new?error=failed_to_add_product";
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                
                    return "redirect:/admin/new?error=failed_to_add_product";
                }
            } else {
               
                return "redirect:/admin/new?error=missing_parameters";
            }
        } else {
            return "redirect:/admin/login";
        }
    }


    private boolean isLoggedIn(HttpSession session) {
        return session.getAttribute("loggedIn") != null && (Boolean) session.getAttribute("loggedIn");
    }
}
