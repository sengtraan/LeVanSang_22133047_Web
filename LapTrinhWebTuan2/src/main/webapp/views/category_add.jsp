<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<form action="${pageContext.request.contextPath}/admin/category/insert" method = "post" enctype="multipart/form-data">
	<label for="cate_name">Category name:</label><br> 
	<input type="text" id="cate_name" name="cate_name"> <br> 
	
	<label for="images">Images:</label> <br>
	<div style = "width:100px; height:100px">
	<img alt = "images" id = "imagess"  height = "100px" width = "100px" src="" />
	</div> <br>
	<input type="file"  onchange= "chooseFile(this)" id="images" name="images" ><br>
	
	<label for="active">Active:</label> <br>
<!-- 	<input type="text" id="active" name="active" ><br>  -->
	<input type="radio" id="active_on" name="active" value = "1" checked>
	<label for = "html" >Active</label><br>
	<input type="radio" id="active_off" name="active" value = "0" >
	<label for = "css" >Block</label> <br>
	<br> <input type="submit" value="Insert">
</form>
