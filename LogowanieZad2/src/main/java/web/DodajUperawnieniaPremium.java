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

@WebServlet("/d")
public class DodajUperawnieniaPremium extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InterfaceListaUzytRepozytorium repozytorium = new ListaUzytkownikowImplementacjaInterface();
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession sessionAnonimowy = httpRequest.getSession();
		int i;
			
		if(sessionAnonimowy.getAttribute("sesjaZalogowany")!=null){
			i = (int) sessionAnonimowy.getAttribute("sesjaZalogowany");
			if(		( ((repozytorium.idUprPremium(i)) == true) && ((repozytorium.idUprAdmin(i)) == true) ) || repozytorium.idUsername(i).equals("admin")	
			  ){
			 response.sendRedirect("dodajUsunPremium.jsp");
			}
			else{
				response.getWriter().println("Nie masz uprawnien do zarzadzania uprawnieniami Premium !");
				response.getWriter().println("Mozesz to obejsc zakladajac konto o loginie 'admin' !");
			 }
		 }
		else{
			response.sendRedirect("dodajUsunPremium.jsp");
		}
		 
	}
}
