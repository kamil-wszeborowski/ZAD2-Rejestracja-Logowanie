package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.DaneRejestracji;
import repositories.InterfaceListaUzytRepozytorium;
import repositories.ListaUzytkownikowImplementacjaInterface;

@WebServlet("/rejestruj")
public class Rejestruj extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaneRejestracji pobierzDaneRejestracji(HttpServletRequest request){
		DaneRejestracji resultRej = new DaneRejestracji();
		resultRej.setUsername(request.getParameter("name"));
		resultRej.setPassword(request.getParameter("password"));
		resultRej.setConfPassword(request.getParameter("con_password"));
		resultRej.setEmail(request.getParameter("email"));
		resultRej.setUprPremium(false);
		resultRej.setUprAdmin(false);
		return resultRej;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaneRejestracji tenUzytkownik = pobierzDaneRejestracji(request);
		InterfaceListaUzytRepozytorium repozytorium = new ListaUzytkownikowImplementacjaInterface();
		HttpSession sessionRejestruj = request.getSession();
		sessionRejestruj.setAttribute("sesjaRejestruj", tenUzytkownik);
		
		if(!(tenUzytkownik.getUsername().equals("")) && 
		   !(tenUzytkownik.getPassword().equals("")) &&
		    (tenUzytkownik.getConfPassword().equals(tenUzytkownik.getPassword())) &&
		   !(tenUzytkownik.getEmail().equals("")) 
		  ){
			repozytorium.add(tenUzytkownik);
			response.sendRedirect("index.jsp");
			//response.getWriter().println("UDA£O SIE");
			//return;
		}else{
			response.sendRedirect("rejestracja.jsp");
		}
	}
}
