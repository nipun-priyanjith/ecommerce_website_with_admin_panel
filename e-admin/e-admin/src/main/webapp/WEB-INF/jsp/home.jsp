<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    

        <style>body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f0f0;
        }
        .container {
            width: 80%;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        .order {
            border: 1px solid #ccc;
            margin-bottom: 20px;
            padding: 20px;
            background-color: #fff;
            display: flex; /* Use flexbox for layout */
            align-items: center; /* Align items vertically */
        }
        .order img {
            width: 300px;
            height: auto;
            margin-right: 20px; /* Add margin to separate image from text */
        }
        .order h2 {
            font-size: 24px;
            margin-bottom: 10px;
        }
        .order p {
            margin: 5px 0;
        }
        .order button {
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            cursor: pointer;
            margin-right: 10px;
        }
        .order button:hover {
            background-color: #0056b3;
        }
                /* Style for the Reject Order button */
        .order button.reject {
            background-color: #dc3545; /* Red background */
        }
        .order button.reject:hover {
            background-color: #c82333; /* Darker red on hover */
        }
                .menu {
            background-color: #FFD700;
            padding: 10px;
            text-align: center;
        }
        .menu button {
            background-color: transparent;
            border: none;
            color: #555;
            font-size: 16px;
            font-weight: bold;
            padding: 10px 20px;
            margin: 0 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .menu button:hover {
            background-color: rgba(255, 255, 255, 0.4);
        }
         .menu form {
        display: inline-block;
    }</style>

    
</head>
<body><div class="menu">
      <form action="new" method="get"><button>Add New Product</button></form>  
      <form action="update" method="get">  <button>Update Product</button></form>  
      <form action="users" method="get">  <button>Users</button></form>  
      <form action="revievs" method="get">  <button>Reviews</button></form>  
    </div><br>

    <div class="container">
        <h1>Orders</h1>
        <%@ page import="java.util.List" %>
        <%@ page import="model.Order" %>
        <%@ page import="java.util.Base64" %> 
        <% 
            List<Order> orderList = (List<Order>) request.getAttribute("orderList");
            for (Order order : orderList) { 
                String base64Image = Base64.getEncoder().encodeToString(order.getImage());
        %>
            <div class="order">
                <img src="data:image/jpeg;base64, <%= base64Image %>" alt="Product Image">
                <div class="order-details">
                    <h2><%= order.getPname() %></h2>
                    <p>Price: <%= order.getPprice() %></p>
                    <p>Discount: <%= order.getPcolor() %></p>
                    <p>Size: <%= order.getPsize() %></p>
                    <p>Customer Name: <%= order.getCname() %></p>
                    <p>Customer Address: <%= order.getCaddress() %>, <%= order.getCcity() %>, <%= order.getCstate() %>, <%= order.getCcountry() %>, <%= order.getCpin() %></p>
                    
<form action="delivered/<%= order.getId() %>" method="post">
    <button class="reject" type="submit">Delivered</button>
</form>

                    

                </div>
            </div>
        <% } %>
    </div>
</body>
</body>
</html>