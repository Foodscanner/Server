package io;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class XMLProductServlet
 */
@WebServlet(description = "Connector from Server to classes", urlPatterns = { "/ProductInformation.xml" })
public class XMLProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XMLProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request,HttpServletResponse response)
    		   throws ServletException,IOException
    		   {
    	String id = request.getParameter("id");
    	PrintWriter pwriter=response.getWriter();
    		       //ServletContext object creation
    		       ServletContext scontext=getServletContext();
    		       
    		       
    		       //id-->convert to long
    		       //
    	        	   response.setContentType("content/xml");
    	        	   pwriter.println(IOUtils.getArticle(1L));
    	           
    	           
    		       pwriter.close();
    		   }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}