<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Card</title>
    <style>
    .order-form label {
    display: block;
    margin-bottom: 10px;
    font-weight: bold;
}

.order-form input[type="text"],
.order-form select {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
    font-size: 16px;
}

.order-form select {
    appearance: none;
    -webkit-appearance: none;
    -moz-appearance: none;
    background: url('data:image/svg+xml;utf8,<svg fill="rgba(0,0,0,0.5)" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"><path d="M10 12L2 4h16z"/></svg>') no-repeat;
    background-position: right 10px center;
    background-size: 15px;
    padding-right: 30px;
}
    
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
        }
        .product {
            margin-bottom: 20px;
            border-bottom: 1px solid #ccc;
            padding-bottom: 20px;
        }
        .product img {
            max-width: 100px;
            height: auto;
            margin-right: 20px;
            border-radius: 5px;
        }
        .product-details {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .product-info {
            flex: 1;
        }
        .product-info p {
            margin: 5px 0;
        }
        .delete-button {
            background-color: #dc3545;
            color: #fff;
            border: none;
            padding: 5px 10px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .delete-button:hover {
            background-color: #bb2d3b;
        }
        .total-price {
            text-align: right;
            margin-top: 20px;
        }
        .heder{text-align: center; 
               color:#555; }
        .pay-button {
            background-color: #FFD700;
            color: #555;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .pay-button:hover {
            background-color: #555;
            color: white;
        }
    </style>
</head>
<body>
    <div class="container">
<%@ page import="model.Product" %>
<%@ page import="model.JavaDict" %>
<%@ page import="java.util.Base64" %> 

<%@ page import= "java.util.HashMap" %>
<%@ page import= "java.util.Map" %>

        <%
            JavaDict productDict = (JavaDict) request.getSession().getAttribute("productDict");
            double totalPrice = 0.0;
            if (productDict != null) {
                Map<String, Object> data = productDict.readAll();
                for (Map.Entry<String, Object> entry : data.entrySet()) {
                    Product product = (Product) entry.getValue();
                    totalPrice += Double.parseDouble(product.getPrice());
        %>
                        <div class="product">
                            <div class="product-details">
                                <div>
                                    <img src="data:image/jpeg;base64, <%= Base64.getEncoder().encodeToString(product.getImage()) %>" alt="Product Image">
                                </div>
                                <div class="product-info">
                                    <p><strong>Name:</strong> <%= product.getName() %></p>
                                    <p><strong>Price:</strong> <%= product.getPrice() %></p>
                                    <p><strong> Size:</strong> <%= product.getSelectedSize() %></p>
                                    <p><strong> Color:</strong> <%= product.getSelectedColor() %></p>
                                </div>
                                <div>
<form action="deleteProduct/<%= entry.getKey() %>" method="post">
    <button class="delete-button" type="submit">Delete</button>
</form>
                                </div>
                            </div>
                        </div>
        <%
                }
            } else {
                out.println("<p>No product details available.</p>");
            }
        %>
        <div class="total-price">
            <p>Total Price: <%= String.format("%.2f", totalPrice) %></p>
        </div><br><br><h2 class="heder">Add Your Shipping Details</h2>
        
<form action="orders" method="POST" class="order-form">
    <label for="name">Full Name:</label>
    <input type="text" id="name" name="name" required>
    <label for="address">Street Address:</label>
    <input type="text" id="address" name="address" required>
    <label for="city">City:</label>
    <input type="text" id="city" name="city" required>
    <label for="state">State/Province:</label>
    <input type="text" id="state" name="state" required>
    <label for="zip">Zip/Postal Code:</label>
    <input type="text" id="zip" name="zip" required>
    <label for="country">Country:</label>
    <select id="country" name="country" required>
        <option value="SriLanka">SriLanka</option>
        <option value="United States">United States</option>
        <option value="Canada">Canada</option>
        <option value="United Kingdom">United Kingdom</option>
    </select>
    
    <button type="submit"  class="pay-button">  Pay now  <%= String.format("%.2f", totalPrice) %></button>
   
</form>


    </div>
   
</body>
</html>
