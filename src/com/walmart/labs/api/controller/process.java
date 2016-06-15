package com.walmart.labs.api.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.walmart.labs.api.model.Product;
import com.walmart.labs.api.search.ReviewSearchImpl;
import com.walmart.labs.api.search.SearchService;

public class process extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("userSearch") != null) {
			// System.out.println(request.getParameter("userSearch"));

			String search = request.getParameter("userSearch");
			List<Product> listAllProduct = new ArrayList<Product>();
			SearchService searchService = new ReviewSearchImpl();
			listAllProduct = searchService.getRecommendedProducts(search);
			if (listAllProduct.size() > 0) {
				Collections.sort(listAllProduct);
				request.setAttribute("listAllProduct", listAllProduct);
				RequestDispatcher rd = request
						.getRequestDispatcher("/productView.jsp");
				rd.forward(request, response);
			} else {
				System.out
						.println("Invalid input, searched product wasn't found");
				RequestDispatcher rd = request
						.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
				return;
			}

			for (Product p : listAllProduct) {
				System.out.println("==>" + p.getItemRating());
			}

		} else {
			System.out.println("Search input wasn't provided");
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}

	}

	// <editor-fold defaultstate="collapsed"
	// desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}