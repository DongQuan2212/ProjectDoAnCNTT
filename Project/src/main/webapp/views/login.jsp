<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<!DOCTYPE html>
<html>
<head>
<style>
<%@ include file ="/css/login.css"%>
</style>
</head>
<body>
<div class="container">
	<form action="${pageContext.request.contextPath}/login" method="post" class="login">
	<c:if test="${alert !=null}">
			<h3 class="alert alertdanger">${alert}</h3>
		</c:if>
		<h1>Đăng nhập</h1>
		<div class="text">
		<label for="username"><b>Username</b></label> <input type="text"
				 name="username" required>
		</div>
			
			<div class="text">
			<label for="password"><b>Password</b></label> <input type="password"
				 name="password" required>
			</div>	
			<button class="loginbtn" type="submit">Login</button>	
			<a>Nếu bạn chưa có tài khoản hãy </a>
			<a href="<c:url value='/register'/>">Đăng kí   </a>
			<div>
			<a href="<c:url value='/rp'/>">Quên mật khẩu</a>	
			</div>
				
	</form>
	</div>
	<script>
	const formLogin= document.querySelectorAll('.text input')
	const formLabel= document.querySelectorAll('.text label')
	for(let i = 0; i<2;i++){
		formLogin[i].addEventListener("mouseover",function(){
			formLabel[i].classList.add("focus")
		})
		formLogin[i].addEventListener("mouseout",function(){
			if(formLogin[i].value=="")
				{
				formLabel[i].classList.remove("focus")
				}
			
		})
		}
	</script>
</body>
</html>