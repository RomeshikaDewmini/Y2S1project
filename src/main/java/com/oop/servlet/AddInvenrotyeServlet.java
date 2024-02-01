package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Inventory;
import com.oop.service.InventoryService;
import com.oop.service.InventoryServiceImpl;


/**
 * Servlet implementation class LoginServlet
 */
public class AddInvenrotyeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddInvenrotyeServlet() {
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

		Inventory inventory = new Inventory();
		
		inventory.setPartName(request.getParameter("partName"));
		inventory.setCategory(request.getParameter("category"));
		inventory.setLocation(request.getParameter("location"));
		inventory.setPrice(Double.valueOf(request.getParameter("price")));
		inventory.setQuantity(Integer.valueOf(request.getParameter("quantity")));
		

		InventoryService inventoryService = new InventoryServiceImpl();
		inventoryService.addInventory(inventory);

		request.setAttribute("inventory", inventory);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListInventory.jsp");
		dispatcher.forward(request, response);
	}

}
