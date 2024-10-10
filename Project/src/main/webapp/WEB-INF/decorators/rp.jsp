<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
<%@ include file ="/css/rp.css"%>
</style>
</head>
<body>
	<div class="container">
		<form action="${pageContext.request.contextPath}/rp" method="post" class="login">
			<c:if test="${alert !=null}">
				<h3 class="alert alertdanger">${alert}</h3>
			</c:if>
			<h1>Quên mật khẩu</h1>
			<p>Hãy điền Email bạn đã đăng kí vào bên dưới.</p>
			<div class="text">
		<label for="email"><b>Email</b></label> <input type="text"
				 name="email" required>
		</div>
				<button type="submit" class="loginbtn">Enter</button>
				<a href="<c:url value='/login'/>">Quay lại  </a>
		</form>
	</div>
	<script>
	const formLogin= document.querySelectorAll('.text input')
	const formLabel= document.querySelectorAll('.text label')
	for(let i = 0; i<5;i++){
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