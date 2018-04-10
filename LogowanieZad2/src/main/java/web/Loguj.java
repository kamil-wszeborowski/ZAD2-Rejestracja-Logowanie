package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.DaneLogowania;
import domain.DaneRejestracji;
import repositories.InterfaceListaUzytRepozytorium;
import repositories.ListaUzytkownikowImplementacjaInterface;

@WebServlet("/loguj")
public class Loguj extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaneLogowania pobierzDaneLogowania(HttpServletRequest request){
		DaneLogowania result = new DaneLogowania();
		result.setUsername(request.getParameter("name"));
		result.setPassword(request.getParameter("password"));
		return result;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaneLogowania daneLog = pobierzDaneLogowania(request);
		InterfaceListaUzytRepozytorium repozytorium = new ListaUzytkownikowImplementacjaInterface();
		boolean prawidloweHaslo = false;
		
		for(int i=0;i<(repozytorium.count());i++){
			if(daneLog.getUsername().equals(repozytorium.idUsername(i)) && 
			   daneLog.getPassword().equals(repozytorium.idPassword(i))
			){
				prawidloweHaslo = true;
				response.sendRedirect("index.jsp");
				HttpSession session = request.getSession();
				session.setAttribute("sesjaZalogowany", i);
				break;
				
			}
		}
		if(prawidloweHaslo == false){
			response.sendRedirect("logowanie.jsp");
		}
	}
}
