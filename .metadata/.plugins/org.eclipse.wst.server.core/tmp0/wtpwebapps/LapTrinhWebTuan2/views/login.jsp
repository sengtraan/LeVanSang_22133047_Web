<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@page import="LapTrinhWeb_Cha.controllers.LoginController"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/
bootstrap.min.css"
	rel="stylesheet">
<title>Đăng nhập tài khoản</title>
</head>
<%
String username = "";
Cookie[] cookies = request.getCookies();
Boolean remember = (Boolean) request.getAttribute("remember");
if ((remember != null && remember == false)) {
	return;
} else if (cookies != null) {
	for (Cookie cookie : cookies) {
		if (cookie.getName().equals("username")) {
	username = cookie.getValue();
	break;
		}
	}
}
// if (cookies != null) {
// 	if (remember == false) {
// 		return;
// 	} else {
// 		for (Cookie cookie : cookies) {
// 	if (cookie.getName().equals("username")) {
// 		username = cookie.getValue();
// 		break;
// 	}
// 		}
// 	}
// }
%>
<body>
	<header class="row">
		<div class="col">
			<div class="alert alert-primary col" align="center">
				<h1>Đăng nhập tài khoản</h1>
			</div>
		</div>
	</header>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-12 col-md-5">
				<form action="login" method="post">
					<c:if test="${alert != null}">
						<h6 class="alert alert-danger">${alert}</h6>
					</c:if>
					<div class="form-group">
						<label for="username">Username:</label> <input type="text"
							id="username" name="username" class="form-control"
							value="<%=username%>" />
					</div>
					<div class="form-group">
						<label for="password">Password: </label> <input type="password"
							id="password" name="password" class="form-control" />
					</div>
					<div class="row mb-4">
						<div class="col d-flex justify-content-center">
							<!-- Checkbox -->
							<div class="form-check">
								<input class="form-check-input" type="checkbox" value="on"
									id="remember" name="remember"
									<%=(username != null && !username.isEmpty()) ? "checked" : ""%> />
								<label class="form-check-label" for="remember"> Remember
									me </label>
							</div>

						</div>

						<div class="col">
							<!-- Simple link -->
							<a href="${pageContext.request.contextPath}/forgotPassword">Forgot
								password?</a>
						</div>
					</div>
					<div class="form-group mt-3" align="center">
						<button type="submit" class="btn btn-primary">Đăng nhập</button>
					</div>
					<!-- 2 column grid layout for inline styling -->
					<div class="form-group mt-3" align="center">
						<!-- Button chuyển hướng tới trang đăng ký -->
						<button type="button" class="btn btn-secondary"
							onclick="window.location.href='views/register.jsp'">Đăng
							ký</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>