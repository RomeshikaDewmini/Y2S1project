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
public class GetInventoryServlet extends HttpServlet {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetInventoryServlet() {
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

 		String partId = request.getParameter("partId");	
		InventoryService inventoryService = new InventoryServiceImpl();
		Inventory inventory = inventoryService.getInventoryByID(partId);

		request.setAttribute("inventory", inventory);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/GetInventory.jsp");
		dispatcher.forward(request, response);
	}

}
