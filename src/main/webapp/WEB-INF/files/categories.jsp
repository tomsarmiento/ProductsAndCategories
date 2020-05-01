<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link href="/css/categories.css" type="text/css" rel="stylesheet" />
<title>Category</title>
</head>
<body>
	<div class="container-fluid">
		<a href="/index">Go back</a>
		<h1>
			<c:out value="${category.name}" />
		</h1>
		<div class="left">
			<h3>Products:</h3>
			<ul class="list-group list-group-flush">
				<c:forEach var="product" items="${category.products}">
					<li class="list-group-item"><c:out value="${product.name}"></c:out></li>
				</c:forEach>
			</ul>
		</div>
		<div class="right">
			<h3>Add product:</h3>
			<form class="form1" action="/categories/${category.id}/add"
				method="get">
				<p class="form-group">
					<select name="id" class="form-control">
						<c:forEach var="product" items="${productsNull}">
							<option value="${product.id}" label="${product.name}" />
						</c:forEach>
					</select>
				</p>
				<input type="submit" value="Add"
					class="form-control btn btn-outline-secondary" />
			</form>
		</div>


	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>