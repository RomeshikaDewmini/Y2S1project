<%@page import="com.oop.model.Inventory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="Inventory.css" />
<!--<link rel="stylesheet" type="text/css" href="Employee.css" />-->
<meta charset="UTF-8">
<title>SLIIT OOP Employee Management</title>
</head>
<body>

	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

	<h2 class="h2">Get Inventory Page</h2>

	SLIIT Inventory Management App for OOP jsp servlet.
	<br>
	<br>
	<%
	Inventory inventory = (Inventory) request.getAttribute("inventory");
	%>

	<form method="POST" action="UpdateInventoryServlet"
		onsubmit="return validateForm()">
		<table>
			<tr>
				<td><input type="hidden" name="partId"
					value="<%=inventory.getPartId()%>" />
			</tr>
			<tr>
				<td>Part Name</td>
				<td><input type="text" name="partName" id="partName"
					value="<%=inventory.getPartName()%>" /></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input type="text" name="price" id="price"
					value="<%=inventory.getPrice()%>" /></td>
			</tr>
			<tr>
				<td>Quantity</td>
				<td><input type="text" name="quantity" id="quantity"
					value="<%=inventory.getQuantity()%>" /></td>
			</tr>
			<tr>
				<td>Category</td>
				<td><input type="text" name="category" id="category"
					value="<%=inventory.getCategory()%>" /></td>
			</tr>
			<tr>
				<td>Location</td>
				<td><input type="text" name="location" id="location"
					value="<%=inventory.getLocation()%>" /></td>
			</tr>
			<tr>
				<td>Added Date</td>
				<td><input type="text" name="dateAdded" id="dateAdded"
					value="<%=inventory.getDateAdded()%>" disabled /> <input
					type="hidden" name="dateAdded"
					value="<%=inventory.getDateAdded()%>" /></td>

			</tr>

			<tr>
				<td colspan="2"><input type="hidden" name="partId"
					value="<%=inventory.getPartId()%>" /> <input type="submit"
					value="Update Inventory" class="update-button" /></td>
			</tr>
		</table>
	</form>

	<script>
		function validateForm() {
			var partId = document.getElementById('partId').value;
			var price = document.getElementById('price').value;
			var quantity = document.getElementById('quantity').value;

			if (partId === "" || price === "" || quantity === "") {
				alert("Part Id, Price, and Quantity are required fields.");
				return false;
			}

			if (isNaN(price) || isNaN(quantity)) {
				alert("Price and Quantity must be numeric values.");
				return false;
			}

			// Validate price (non-negative)
			if (isNaN(price) || price < 0) {
				alert("Price must be a non-negative number.");
				return false;
			}

			// Validate quantity (non-negative)
			if (isNaN(quantity) || quantity < 0) {
				alert("Quantity must be a non-negative integer.");
				return false;
			}

			return true;
		}
	</script>


	<table>
		<tr>
			<td colspan="2">
				<form method="POST" action="DeleteInventoryServlet">
					<input type="hidden" name="partId"
						value="<%=inventory.getPartId()%>" /> <input type="submit"
						value="Delete Inventory Item" class="delete-button" />
				</form>
			</td>

		</tr>
	</table>


	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>

</body>
</html>