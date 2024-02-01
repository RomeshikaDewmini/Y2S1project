<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="Inventory.css" />
<meta charset="UTF-8">

<title>SLIIT OOP Inventory Management</title>
</head>
<body class="body">
	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

	<h2 class="h2">Add Inventory Page</h2>

	SLIIT Inventory Management App for Object Oriented Programming
	<br>
	<br>

	<form method="POST" action="AddInventoryServlet"
		onsubmit="return validateForm()">
		<table>

			<tr>
				<td>Part Id</td>
				<td><input type="text" name="partId" id="partId" /></td>
			</tr>
			<tr>
				<td>Part Name</td>
				<td><input type="text" name="partName" id="partName" /></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input type="text" name="price" id="price" /></td>
			</tr>
			<tr>
				<td>Quantity</td>
				<td><input type="text" name="quantity" id="quantity" /></td>
			</tr>
			<tr>
				<td>Category</td>
				<td><input type="text" name="category" id="category" /></td>
			</tr>
			<tr>
				<td>Location</td>
				<td><input type="text" name="location" id="location" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Add Inventory"
					class="add-button" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="reset" value="Reset"
					class="reset-button" /></td>
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

	<form method="POST" action="ListInventoryServlet">
		<table>
			<tr>
				<td colspan="2"><input type="submit" value="List All Inventory"
					class="list-button" /></td>
			</tr>
		</table>
	</form>

	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>

</body>
</html>