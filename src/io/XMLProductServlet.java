package io;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class XMLProductServlet
 */
@WebServlet(description = "Connector from Server to classes", urlPatterns = { "/ProductInformation.xml" })
public class XMLProductServlet extends HttpServlet {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = -6688374884589513303L;


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
    		       //ServletContext object creation
    		       ServletContext scontext=getServletContext();
    		       
    		       
    		       //id-->convert to long
    		       //  
    		       	   String ean = request.getParameter("ean");
    		       	   System.out.println(ean);
    	        	   response.setContentType("content/xml");
    	        	   response.setCharacterEncoding("UTF-8");
    	        	   ServletOutputStream os = response.getOutputStream();
    	        	   os.print(IOUtils.getArticle(ean));
    	        	   os.print("<!--Generated @"+ InetAddress.getLocalHost().getHostName() + " on: " + new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())+"-->");
    	        	   os.flush();
    	        	   os.close();
    	           
    		       
    		   }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
