package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repositories.InterfaceListaUzytRepozytorium;
import repositories.ListaUzytkownikowImplementacjaInterface;


@WebServlet("/r")
public class Rejestracja extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	InterfaceListaUzytRepozytorium repozytorium = new ListaUzytkownikowImplementacjaInterface();
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession sessionAnonimowy = httpRequest.getSession();
	//	int i;
		
		if(sessionAnonimowy.getAttribute("sesjaZalogowany")!=null){
		//	i = (int) sessionAnonimowy.getAttribute("sesjaZalogowany");
		// if(((repozytorium.idUprPremium(i)) == false) &&
		//		   ((repozytorium.idUprAdmin(i)) == false)
		//   )
			 	response.sendRedirect("/pr");
		}
		else{
			response.sendRedirect("rejestracja.jsp");
		}
	}
}
