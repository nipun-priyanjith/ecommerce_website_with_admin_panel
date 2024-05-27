<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Product Information</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #F0F0F0;
            color: #333;
        }
        .container {
            max-width: 800px;
            margin: 30px auto;
            padding: 30px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0,0,0,0.2);
            border-radius: 5px;
        }
        h1 {
            margin-top: 0;
            color: #FFD700;
        }
        .product-details {
            display: flex;
            align-items: center;
        }
        .product-image img {
            max-width: 400px;
            max-height:500px;
            height: auto;
            transition: transform 0.3s ease;
        }
        .product-image img:hover {
            transform: scale(1.1);
        }
        .product-info {
            margin-left: 20px;
        }
        p {
            margin: 5px 0;
        }
        .buy-button {
            background-color: #FFD700;
            color: #555;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
        }
        .buy-button:hover {
             background-color: #555;
             color: #fff;
        }
        /* Style radio buttons */
        input[type="radio"] {
            display: none;
        }
        label.option {
            display: inline-block;
            margin-right: 10px;
            padding: 8px 16px;
            background-color: #eee;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="radio"]:checked + label.option {
            background-color: yellow;
            color: #555;
        }
    </style>
</head>
<body>
    <div class="container">
        <%@ page import="model.Product" %>
        <%@ page import="java.util.Base64" %>
        <% Product product = (Product) request.getSession().getAttribute("product");
           if (product != null) { %>
            <h1><%= product.getName() %></h1>
            <div class="product-details">
                <div class="product-image">
                    <img src="data:image/jpeg;base64, <%= Base64.getEncoder().encodeToString(product.getImage()) %>" alt="Product Image">
                </div>
                <div class="product-info">
                    <p><h3><strong></strong> <%= product.getName() %></h3></p>
                    <p>The series follows Rick Sanchez, an alcoholic, nihilistic super-scientist, and his easily distressed grandson,
                     Morty Smith to parallel dimensions and exotic planets with extraterrestrials. These adventures commonly cause trouble for Morty's 
                     family—Jerry, Beth, and Summer—who are often dragged along as well.</p><br>
                    <p><strong>Price:</strong> <%= product.getPrice() %></p>
                    <p><strong>Discount:</strong> <%= product.getDiscount() %></p>
                    <p><strong></strong> <%= product.getRating() %></p><br>

                    
                   <form action="card" method="post">
                     
                     <input type="hidden" name="id" value="<%= product.getId() %>">
                     <input type="hidden" name="productName" value="<%= product.getName() %>">
                     <input type="hidden" name="productPrice" value="<%= product.getPrice() %>">
                     <input type="hidden" name="productRating" value="<%= product.getRating() %>">
                     <input type="hidden" name="productImage" value="<%= Base64.getEncoder().encodeToString(product.getImage()) %>">

                    <p><strong>Choose a Size:</strong></p>
                    <input type="radio" id="small" name="size" value="small">
                    <label for="small" class="option">Small</label>
                    <input type="radio" id="medium" name="size" value="medium">
                    <label for="medium" class="option">Medium</label>
                    <input type="radio" id="large" name="size" value="large">
                    <label for="large" class="option">Large</label>
                    <input type="radio" id="xl" name="size" value="xl">
                    <label for="xl" class="option">XL</label><br>

                   
                    <p><strong>Choose a Color:</strong></p>
                    <input type="radio" id="red" name="color" value="red">
                    <label for="red" class="option">Red</label>
                    <input type="radio" id="blue" name="color" value="blue">
                    <label for="blue" class="option">Blue</label>
                    <input type="radio" id="green" name="color" value="green">
                    <label for="green" class="option">Green</label>
                    <input type="radio" id="yellow" name="color" value="yellow">
                    <label for="yellow" class="option">Yellow</label><br>
                    <br>
                     
   
                     <button type="submit" class="buy-button"><%= product.getPrice() %> Buy Now</button>
                  </form>

                </div>
            </div>
        <% } else { %>
            <p>No product selected</p>
        <% } %>
    </div>
    
</html>
