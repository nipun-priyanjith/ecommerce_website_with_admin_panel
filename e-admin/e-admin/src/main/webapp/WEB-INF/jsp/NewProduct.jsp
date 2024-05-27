<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
    }
    .container {
        width: 50%;
        margin: 50px auto;
        background-color: #fff;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    label {
        display: block;
        font-weight: bold;
    }
    input[type="text"], input[type="file"] {
        width: calc(100% - 20px);
        padding: 10px;
        margin-bottom: 20px;
        border-radius: 5px;
        border: 1px solid #ccc;
    }
    input[type="submit"] {
        background-color: #FFD700;
        color: #555;
        border: none;
        padding: 10px 20px;
        border-radius: 5px;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #555;
        color:white;
    }
</style>
</head>
<body>
<div class="container">
    <h2>Add new product</h2>
<form action="add" method="post" enctype="multipart/form-data">
    <label for="productName">Product Name:</label>
    <input type="text" id="productName" name="productName" required><br><br>
    
    <label for="productPrice">Product Price:</label>
    <input type="text" id="productPrice" name="productPrice" required><br><br>
    
    <label for="productDiscount">Product Discount:</label>
    <input type="text" id="productDiscount" name="productDiscount"><br><br>
    
    <label for="productRating">Product Rating:</label>
    <input type="text" id="productRating" name="productRating"><br><br>
    
    <label>Product Images:</label>
    <input type="file" name="file"/><br><br>

    <input type="submit" value="Add Product">
</form>
    
</div>
</body>
</html>