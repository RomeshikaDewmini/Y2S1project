<%@page import="com.oop.model.Inventory"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.service.InventoryServiceImpl"%>
<%@page import="com.oop.service.InventoryService"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel = "stylesheet"
   type = "text/css"
   href = "Inventory.css" />
<!-- <link rel="stylesheet" type="text/css" href="Employee.css" />-->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SLIIT OOP Inventory Management</title>
</head>
<body>
	<h3>List of Inventory</h3>
	SLIIT Inventory Management App for OOP jsp servlet.
	<br>
	<br>
	<div align="left">
		<table border="1" cellpadding="12">
			<caption>
				<h2>List of Inventory</h2>
			</caption>
			<a href="homeView.jsp">Add Inventory</a>
			<tr>
				<th>Part Id</th>
				<th>Part Name</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Category</th>
				<th>Location</th>
				<th>Date Added</th>
				<th>Date Modified</th>
				<th>Select</th>
			</tr>
			<%
			InventoryService inventoryService = new InventoryServiceImpl();
			ArrayList<Inventory> arrayList = inventoryService.getInventories();

			for (Inventory inventory : arrayList) {
			%>
			<tr>
				<td><%=inventory.getPartId()%></td>
				<td><%=inventory.getPartName()%></td>
				<td><%=inventory.getPrice()%></td>
				<td><%=inventory.getQuantity()%></td>
				<td><%=inventory.getCategory()%></td>
				<td><%=inventory.getLocation()%></td>
				<td><%=inventory.getDateAdded()%></td>
				<td><%=inventory.getDateModified()%></td>
				<td>
					<form method="POST" action="GetInventoryServlet">
						<input type="hidden" name="partId"
							value="<%=inventory.getPartId()%>" /> <input type="submit"
							value="Select Inventory" class="select-button" />
					</form>
				</td>
			</tr>
			<%
			}
			%>
		</table>
	</div>

</body>
</html>