<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri = "jakarta.tags.core" %>

<a href="${pageContext.request.contextPath}/admin/category/add"> Add Category</a>
<a id="searchBtn" href="#" onclick="toggleSearch()"> Search Category</a>
<input type="text" id="searchInput" style="display:none;" placeholder="..." />
<button id="doSearch" style="display:none;" onclick="searchCategory()">Find</button>

<a href="${pageContext.request.contextPath}/categories"> Reset</a>
<table border = "1" width = "100%">
	<tr>
		<th>STT</th>
		<th>Images</th>
		<th>CategoryID</th>
		<th>CategoryName</th>
		<th>Active</th>
		<th>Action</th>
	</tr>
	<tr>
		<c:forEach items="${cateList}" var="cate" varStatus="STT">
			<tr class="odd gradeX">
				<td>${STT.index+1}</td>
				<td>
				
				<c:if test ="${cate.images.substring(0, 5) != 'https'}">
					<c:url value="/image?fname=${cate.images}" var="imgUrl"></c:url>
				</c:if>
				<c:if test ="${cate.images.substring(0, 5) == 'https'}">
					<c:url value="${cate.images}" var="imgUrl"></c:url>
				</c:if>
				<img height="150" width="200" src="${imgUrl}" />
				
				</td>
				
				<td>${cate.cate_id}</td>
				<td>${cate.cate_name }</td>
				
				<td>
				
				<c:if test = "${cate.active == true}" >
					<span> Active </span>
				</c:if>
				<c:if test = "${cate.active != true}" >
					<span> Blocked </span>
				</c:if>
				
				</td>
				<td><a
					href="<c:url value='/admin/category/edit?id=${cate.cate_id }'/>">Edit</a> 
					| <a
					href="<c:url value='/admin/category/delete?id=${cate.cate_id }'/>">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</tr>
</table>

<script>
    // Hàm hiển thị và ẩn textbox tìm kiếm
    function toggleSearch() {
        var searchInput = document.getElementById("searchInput");
        var doSearchBtn = document.getElementById("doSearch");
        if (searchInput.style.display === "none") {
            searchInput.style.display = "inline";
            doSearchBtn.style.display = "inline";
        } else {
            searchInput.style.display = "none";
            doSearchBtn.style.display = "none";
        }
    }

    // Hàm thực hiện tìm kiếm bằng cách chuyển hướng với từ khóa
    function searchCategory() {
        var keyword = document.getElementById("searchInput").value;
        if (keyword.trim() !== "") {
            window.location.href = `${window.location.origin}${window.location.pathname}?keyword=` + keyword;
        }
    }
</script>