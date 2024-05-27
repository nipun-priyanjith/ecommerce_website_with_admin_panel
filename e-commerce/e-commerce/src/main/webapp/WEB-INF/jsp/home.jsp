<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
   <title>E-commerce</title>
    
    <style>
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

/* Body styles */
body {
    font-family: Arial, sans-serif;
    background-color: #F0F0F0;
}

/* Header styles */
header {
    background-color: #FFD700;
    color: #555;
    padding: 30px 0;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
}

.header-container {
    max-width: 1200px;
    margin: 0 auto;
    display: flex;
    justify-content: space-between;
    align-items: center;
    
}

.logo h1 {
    font-size: 24px;
}

nav ul {
    list-style-type: none;
}

nav ul li {
    display: inline-block;
    margin-right: 20px;
}

nav ul li a {
    color: #555;
    text-decoration: none;
}
.searchBar {
            position: relative;
            flex-grow: 1; /* Allow search bar to grow and shrink */
            margin-left: 300px; /* Adjust margin as needed */
        }

.searchBar input[type="text"] {
            padding: 10px;
            border: none;
            border-radius: 5px;
            width: 100%; /* Adjust width as needed */
            max-width: 750px; /* Set maximum width */
            outline: none;
        }

.searchBar button[type="submit"] {
            background-color: #555;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
        }

.searchBar button[type="submit"]:hover {
            background-color: #333;
        }

        /* Media query for smaller screens */
@media (max-width: 768px) {
            .searchBar {
                margin-left: 10px; /* Adjust margin for smaller screens */
            }
        }

/* Banner styles */
.banner {
    margin-top: 20px;
}

/* Product grid styles */
.product-grid {
    max-width: 1200px;
    margin: 20px auto;
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(270px, 1fr)); /* Adjusted minmax for product item card width */
    grid-gap: 20px;
}

.product-item {
    width: 300px; /* Fixed width */
    height: 350px; /* Fixed height */
    background-color: #fff;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    padding: 20px;
    display: flex;
    flex-direction: column; /* Align items vertically */
}

.product-image {
    width: 100%; /* Ensure image takes full width of product item */
    height: 250px; /* Fixed height for image */
    overflow: hidden; /* Ensure image doesn't overflow product item */
    border-radius: 5px;
}

.product-image img {
    width: 100%;
    height: auto;
    object-fit: cover; /* Ensures the image covers the entire container */
    transition: transform 0.3s; /* Add transition for smooth scaling */
}
.product-image img:hover {
    transform: scale(1.1);
}

.product-details {
    display: flex;
    flex-direction: column; /* Align items vertically */
}

.product-details h2 {
    margin-top: 10px;
}

.add-to-cart {
    width:100%;
    margin-top: auto; /* Push button to the bottom */
    background-color: #FFD700;
    color: #555;
    border: none;
    padding: 10px 20px;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s;
}

.add-to-cart:hover {
    background-color: #555;
    color: #fff;
}
.infinity-button {
	
    background-color: #FFD700; /* Background color */
    color: #555; /* Text color */
    border: 2px solid #FFD700; /* Border */
    padding: 10px 20px; /* Padding */
    font-size: 16px; /* Font size */
    font-weight: bold; /* Font weight */
    border-radius: 5px; /* Rounded corners */
    cursor: pointer; /* Cursor on hover */
    transition: background-color 0.3s, color 0.3s; /* Smooth transition */
}

.infinity-button:hover {
    background-color: #555; /* Background color on hover */
    color: #FFD700; /* Text color on hover */
}


/* Footer styles */
footer {
    background-color: #333;
    color: #fff;
    padding: 20px 0;
    margin-top: 20px;
}

.footer-container {
    max-width: 1200px;
    margin: 0 auto;
    display: flex;
    justify-content: space-between;
}

.contact-us, .about-us {
    width: 45%;
}

.contact-us h3, .about-us h3 {
    margin-bottom: 10px;
}

.contact-us ul, .about-us ul {
    list-style-type: none;
}

.contact-us ul li, .about-us ul li {
    margin-bottom: 5px;
}

.contact-us ul li:before, .about-us ul li:before {
    content: "\2022"; /* Bullet point */
    color: #fff;
    margin-right: 5px;
}

.infinity-button {
    
    background-color: #FFD700; /* Background color */
    color: #555; /* Text color */
    border: 2px solid #FFD700; /* Border */
    padding: 10px 20px; /* Padding */
    font-size: 16px; /* Font size */
    font-weight: bold; /* Font weight */
    border-radius: 5px; /* Rounded corners */
    cursor: pointer; /* Cursor on hover */
    transition: background-color 0.3s, color 0.3s; /* Smooth transition */
}

.infinity-button:hover {
    background-color: #555; /* Background color on hover */
    color: #FFD700; /* Text color on hover */
}
    .centered {
        text-align: center;
    }


    </style>

</head>
<body>
    <header>
        <div class="header-container">
            <div class="logo">
                <h1>E-commerce</h1>
            </div>

            <nav>
                <ul>
                    <li><a href="#">My Orders</a></li>
                    <li><a href="#">Profile</a></li>
                </ul>
            </nav>
        </div>
                                         <!-- Search bar -->
            <div class="searchBar">
                   <input type="text" placeholder="Search products...">
                   <button type="submit">Search</button>
            </div>
       
        


    </header>
<div class="product-grid">    
<%@ page import="java.util.List" %>
<%@ page import="model.Product" %>
<%@ page import="java.util.Base64" %> <!-- Import Base64 -->

<!-- Product Grid Here -->
<!-- Use a traditional for loop to iterate through the productList -->
<% int count = 0;
    List<Product> productList = (List<Product>) request.getAttribute("productList");
    for (Product product : productList) { 
        if(count < 12){
            // Convert byte array to Base64 string
            String base64Image = Base64.getEncoder().encodeToString(product.getImage());
%>
    <div class="product-item">
        <div class="product-image">
            <img src="data:image/jpeg;base64, <%= base64Image %>" alt="Product Image">
        </div>
        <div class="product-details">
            <h2><%= product.getName() %></h2>
            <p>Price: <%= product.getPrice() %></p>
            <p>Discount: <%= product.getDiscount() %></p>
            <p>Rating: <%= product.getRating() %></p>
                    <form action="prodactinfo" method="post"> <!-- Change action to ProductServlet -->
                        <input type="hidden" name="id" value="<%= product.getId() %>">
                        <input type="hidden" name="productName" value="<%= product.getName() %>">
                        <input type="hidden" name="productPrice" value="<%= product.getPrice() %>">
                        <input type="hidden" name="productDiscount" value="<%= product.getDiscount() %>">
                        <input type="hidden" name="productRating" value="<%= product.getRating() %>">
                        <input type="hidden" name="productImage" value="<%= Base64.getEncoder().encodeToString(product.getImage()) %>">
                        <button type="submit" class="add-to-cart">Add to card</button> <!-- Change button type to submit -->
                    </form>
        </div>
    </div>
<% 
    count++;
    } else {
        break;
    }
} 
%>
</div>
<br> 

    
    <br><div class="centered">
    <form action="infinity" method="GET">
        <button type="submit" class="infinity-button">infinity products</button>
    </form></div>
    

<br><br>


        
    <footer>
        <div class="footer-container">
            <div class="contact-us">
                <h3>Contact Us:</h3>
                <ul>
                    <li><a href="#">FB</a></li>
                    <li><a href="#">Twitter</a></li>
                    <li><a href="#">WhatsApp</a></li>
                </ul>
            </div>
            <div class="about-us">
                <h3>About Us:</h3>
                <ul>
                    <li><a href="#">Our Mission</a></li>
                    <li><a href="#">Our Vision</a></li>
                    <li><a href="#">About Us</a></li>
                </ul>
            </div>
        </div>
    </footer>
</body>
</html>