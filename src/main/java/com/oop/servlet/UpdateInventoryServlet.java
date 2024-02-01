package com.oop.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Inventory;
import com.oop.service.InventoryService;
import com.oop.service.InventoryServiceImpl;

/**
 * Update Inventory servlet
 */
public class UpdateInventoryServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateInventoryServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		  String date = request.getParameter("dateAdded");
		//convert String to LocalDate
		LocalDate localDateAdded = LocalDate.parse(date, formatter);

		Inventory inventory = new Inventory();
		String partId = request.getParameter("partId");	
		inventory.setPartName(request.getParameter("partName"));
		inventory.setCategory(request.getParameter("category"));
		inventory.setLocation(request.getParameter("location"));
		inventory.setPrice(Double.valueOf(request.getParameter("price")));
		inventory.setQuantity(Integer.valueOf(request.getParameter("quantity")));
		inventory.setPartId(partId);
		inventory.setDateAdded(localDateAdded);
		
		InventoryService inventoryService = new InventoryServiceImpl();
		inventoryService.updateInventory(partId, inventory);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListInventory.jsp");
		dispatcher.forward(request, response);
	}

}
