<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<link rel="stylesheet" href="css/home.css">
</head>
<body>
	<header class="header">
		<a href="#" class="logo"> <img src="images/coffee-cup.png" alt="">
		</a>
		<nav class="navbar">
			<a href="#home">Home</a> <a href="#home">About</a> <a href="#home">Menu</a>
			<a href="#home">Review</a> <a href="#home">Contact</a>
		</nav>
		<div class="icons">
			<div class="fas fa-search" id="search-btn"></div>
			<div class="fas fa-shopping-cart" id="cart-btn"></div>
			<div class="fas fa-bars" id="menu-btn"></div>
		</div>
		<div class="search-form">
			<input type="search" id="search-box" placeholder="Tìm kiếm ở đây....">
			<label for="search-box" class="fas fa-search" id="search-btn"></label>
		</div>
		<div class="cart-items-container">
			<div class="cart-item">
				<span class="fas fa-times"> </span> <img alt=""
					src="images/coffee-cup.png">
				<div class=" content">
					<h3>Sản phẩm 1</h3>
					<div class="price">15.000</div>
				</div>
			</div>
			<div class="cart-item">
				<span class="fas fa-times"> </span> <img alt=""
					src="images/coffee-cup.png">
				<div class=" content">
					<h3>Sản phẩm 2</h3>
					<div class="price">15.000</div>
				</div>
			</div>
			<a href="#" class="btn">Thanh toán</a>
		</div>

	</header>

<script src="script/home.js"></script>
</body>
</html>