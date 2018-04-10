package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/l")
public class Logowanie extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession sessionAnonimowy = httpRequest.getSession();
		
		if(sessionAnonimowy.getAttribute("sesjaZalogowany")!=null){ 
			 response.sendRedirect("/pr");
		}
		else{
			response.sendRedirect("logowanie.jsp");
		}
		
	}
}
