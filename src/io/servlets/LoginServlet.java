package io.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.UserUtil;
import foodServer.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
       
    /**
	 * 
	 */
	private static final long serialVersionUID = -7988625046817533520L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println(request.getParameter("email"));
		//System.out.println("password:" + request.getParameter("password"));
		try { User user = new User();
		user = UserUtil.retrieveUser(request.getParameter("email"));
		if (user != null && user.passwortCorrect(request.getParameter("password"))) {
			//System.out.println("User: " + user);
			//System.out.println("Passwort: " + request.getParameter("password") + " is correct: " + user.passwortCorrect(request.getParameter("password")));
			//System.out.println(user);
			HttpSession session = request.getSession(true); 
			session.setAttribute("currentSessionUser",user);
			System.out.println(request.getParameter("from"));
			response.sendRedirect(request.getParameter("from")); //logged-in page 
			} 
		else {
			response.sendError(401); //error page 
			}
		} 
		catch (Throwable theException) { 
			System.out.println(theException); 
			} 
		finally{
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
