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

@WebServlet("/dodajAdmin")
public class DodajAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private DaneRejestracji pobierzDaneDodajAdmin(HttpServletRequest request){
		DaneRejestracji resultDodaj = new DaneRejestracji();
		boolean zTrueFalse = false;
		String zPassword = null;
		String zEmail = null;
		
		resultDodaj.setPassword(zPassword);
		resultDodaj.setEmail(zEmail);
		resultDodaj.setUprPremium(zTrueFalse);
		
		resultDodaj.setUsername(request.getParameter("name"));
		resultDodaj.setUprAdmin(true);
		return resultDodaj;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaneRejestracji daneDodaj = pobierzDaneDodajAdmin(request);
		InterfaceListaUzytRepozytorium repozytorium = new ListaUzytkownikowImplementacjaInterface();
		boolean znalezionoUzytkownika = false;
		
		//Jezeli jest uzytkownik to dodaj uprawnienia premium jezeli nie to przejdz z powortem 
		
		for(int i=0;i<(repozytorium.count());i++){
			if(daneDodaj.getUsername().equals(repozytorium.idUsername(i))
			){
				znalezionoUzytkownika = true;
				
				daneDodaj.setPassword(repozytorium.idUsername(i));
				daneDodaj.setEmail(repozytorium.idEmail(i));
				daneDodaj.setUprPremium(repozytorium.idUprPremium(i));
				
				repozytorium.zmienUprAdmin(i, daneDodaj);
				response.sendRedirect("index.jsp");
				break;
			}
		}
		
		if(znalezionoUzytkownika == false){
			response.sendRedirect("dodajUsunPremium.jsp");
		}
	}


}
