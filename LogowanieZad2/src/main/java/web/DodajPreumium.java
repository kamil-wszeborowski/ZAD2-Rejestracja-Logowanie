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

@WebServlet("/dodajPremium")
public class DodajPreumium extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	private DaneRejestracji pobierzDaneDodajPremium(HttpServletRequest request){
		DaneRejestracji resultDodaj = new DaneRejestracji();
		boolean zTrueFalse = false;
		String zPassword = null;
		String zEmail = null;
		
		resultDodaj.setPassword(zPassword);
		resultDodaj.setEmail(zEmail);
		resultDodaj.setUprAdmin(zTrueFalse);
		
		resultDodaj.setUsername(request.getParameter("name"));
		resultDodaj.setUprPremium(true);
		return resultDodaj;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaneRejestracji daneDodaj = pobierzDaneDodajPremium(request);
		InterfaceListaUzytRepozytorium repozytorium = new ListaUzytkownikowImplementacjaInterface();
		boolean znalezionoUzytkownika = false;
		
		//Jezeli jest uzytkownik to dodaj uprawnienia premium jezeli nie to przejdz z powortem 
		
		for(int i=0;i<(repozytorium.count());i++){
			if(daneDodaj.getUsername().equals(repozytorium.idUsername(i))
			){
				znalezionoUzytkownika = true;
				
				daneDodaj.setPassword(repozytorium.idUsername(i));
				daneDodaj.setEmail(repozytorium.idEmail(i));
				daneDodaj.setUprAdmin(repozytorium.idUprAdmin(i));
				
				repozytorium.zmienUprPremium(i, daneDodaj);
				response.sendRedirect("index.jsp");
				break;
			}
		}
		
		if(znalezionoUzytkownika == false){
			response.sendRedirect("dodajUsunPremium.jsp");
		}
	}
}
