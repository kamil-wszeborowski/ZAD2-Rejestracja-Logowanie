package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.DaneRejestracji;
import repositories.InterfaceListaUzytRepozytorium;
import repositories.ListaUzytkownikowImplementacjaInterface;

@WebServlet("/usunPremium")
public class UsunPremium extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DaneRejestracji pobierzDaneDodajPremium(HttpServletRequest request){
		DaneRejestracji resultUsun = new DaneRejestracji();
		boolean zTrueFalse = false;
		String zPassword = null;
		String zEmail = null;
		
		resultUsun.setPassword(zPassword);
		resultUsun.setEmail(zEmail);
		resultUsun.setUprAdmin(zTrueFalse);
		
		resultUsun.setUsername(request.getParameter("name"));
		resultUsun.setUprPremium(false);
		return resultUsun;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaneRejestracji daneUsun = pobierzDaneDodajPremium(request);
		InterfaceListaUzytRepozytorium repozytorium = new ListaUzytkownikowImplementacjaInterface();
		boolean znalezionoUzytkownika = false;
		
		//Jezeli jest uzytkownik to usun uprawnienia premium jezeli nie to przejdz z powortem 
		
		for(int i=0;i<(repozytorium.count());i++){
			if(daneUsun.getUsername().equals(repozytorium.idUsername(i))
			){
				znalezionoUzytkownika = true;
				
				daneUsun.setPassword(repozytorium.idUsername(i));
				daneUsun.setEmail(repozytorium.idEmail(i));
				daneUsun.setUprAdmin(repozytorium.idUprAdmin(i));
				
				repozytorium.zmienUprPremium(i, daneUsun);
				response.sendRedirect("index.jsp");
				break;
			}
		}
		
		if(znalezionoUzytkownika == false){
			response.sendRedirect("dodajUsunPremium.jsp");
		}
		
	}
}
