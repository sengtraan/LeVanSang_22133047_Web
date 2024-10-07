<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri = "jakarta.tags.core" %>

<form action="${pageContext.request.contextPath}/admin/category/update"
	method="post" enctype="multipart/form-data">
	<br> 
	<input type="text" id="cate_id" name="cate_id" value="${cate.cate_id}" hidden = "hidden">
	<br>
	
	<label for="cate_name">Category name:</label><br> <input
		type="text" id="cate_name" name="cate_name" value="${cate.cate_name}"><br>

	<label for="images">Images:</label> <br>
	<c:if test="${cate.images.substring(0, 5) != 'https'}">
		<c:url value="/image?fname=${cate.images}" var="imgUrl"></c:url>
	</c:if>
	<c:if test="${cate.images.substring(0, 5) == 'https'}">
		<c:url value="${cate.images}" var="imgUrl"></c:url>
	</c:if>
	<img height="150" width="200" src="${imgUrl}" /> <input type="file"
		id="images" name="images" value="${cate.images}"><br>

	<label for="active">Active:</label> <br> <input type="text"
		id="active" name="active" value="${cate.active}"><br>
	<br> <input type="submit" value="Submit">
</form>
