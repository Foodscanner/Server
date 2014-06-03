package io.servlets;

import io.baseClasses.IOArticle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import foodServer.Article;
import foodServer.exceptions.DatabaseConnectionException;
import foodServer.exceptions.NumberInvalidFormatException;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet(description = "edit-product", urlPatterns = { "/Product/*" })
public class ProductServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("mode").equals("view")){
			System.out.println(request.getParameter("mode"));
			request.setAttribute("ean", request.getParameter("ean"));
			response.sendRedirect("/product.jsp?ean="+request.getParameter("ean"));
		}else{
			System.out.println(request.getParameterMap());
			String ean = request.getParameter("ean");
			String header = "";
			Article article = null;
			HttpSession session = request.getSession();
			if (!session.isNew()) {
				if(ean != null)
					header = ("Edit article " + ean);
				    try {
						article = IOArticle.getArticle(ean);
					} catch (NumberFormatException | DatabaseConnectionException
							| NumberInvalidFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    if(article == null){
				    	article = new Article();
				    }
				    request.setAttribute("headerOne", header);
				    request.setAttribute("article", article); // Will be available as ${article} in JSP
			        request.getRequestDispatcher("/product/edit.jsp").forward(request, response);
			}
			else {
				response.sendRedirect("../login.jsp?from=/Product/edit?ean="+ean);
			}			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
