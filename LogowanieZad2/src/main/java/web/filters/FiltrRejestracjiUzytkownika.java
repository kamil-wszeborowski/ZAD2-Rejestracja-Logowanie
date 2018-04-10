package web.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import domain.DaneRejestracji;
import repositories.InterfaceListaUzytRepozytorium;
import repositories.ListaUzytkownikowImplementacjaInterface;

@WebFilter("/rejestruj")
public class FiltrRejestracjiUzytkownika implements Filter {

	private DaneRejestracji pobierzDaneRejestracji(ServletRequest request){
		DaneRejestracji resultRej = new DaneRejestracji();
		resultRej.setUsername(request.getParameter("name"));
		resultRej.setPassword(request.getParameter("password"));
		resultRej.setConfPassword(request.getParameter("con_password"));
		resultRej.setEmail(request.getParameter("email"));
		resultRej.setUprPremium(false);
		return resultRej;
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		DaneRejestracji tenUzytkownik = pobierzDaneRejestracji(request);
		InterfaceListaUzytRepozytorium repozytorium = new ListaUzytkownikowImplementacjaInterface();
		
		for(int i=0;i<(repozytorium.count());i++){
			if((tenUzytkownik.getUsername().equals(repozytorium.idUsername(i))) && 
			   (tenUzytkownik.getEmail().equals(repozytorium.idEmail(i))) 
			  ){
				response.getWriter().println("Taki uzytkownik juz istnieje.");
				return;
			  }
		}
		/*if(repozytorium.contains(tenUzytkownik))*/
		chain.doFilter(request, response);
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
