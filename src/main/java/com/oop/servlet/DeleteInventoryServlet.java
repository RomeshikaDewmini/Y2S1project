package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.service.InventoryService;
import com.oop.service.InventoryServiceImpl;


/**
 * Delete inventory servlet
 */
public class DeleteInventoryServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1871871796669342804L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteInventoryServlet() {
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
		inventoryService.removeInventory(partId);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListInventory.jsp");
		dispatcher.forward(request, response);
	}

}
