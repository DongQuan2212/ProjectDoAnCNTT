<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<header class="header">
		<a href="${pageContext.request.contextPath}/home" class="logo"> <img
			src="images/coffee-cup.png" alt="">
		</a>
		<nav class="navbar">
			<a href="${pageContext.request.contextPath}/home">Home</a> <a
				href="${pageContext.request.contextPath}/about">About</a> <a
				href="${pageContext.request.contextPath}/menu">Menu</a> <a
				href="${pageContext.request.contextPath}/review">Review</a> <a
				href="${pageContext.request.contextPath}/contact">Contact</a>
		</nav>
		<div class="icons">
	
			<c:choose>
				<c:when test="${sessionScope.account == null}">
					<a href="${pageContext.request.contextPath}/login">Login</a>
					<a href="${pageContext.request.contextPath}/register">Register</a>
				</c:when>
				<c:otherwise>
					<a href="${pageContext.request.contextPath}/profile">${sessionScope.account.fullname}</a>
					<a href="${pageContext.request.contextPath}/logout">Logout</a>
				</c:otherwise>
			</c:choose>



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