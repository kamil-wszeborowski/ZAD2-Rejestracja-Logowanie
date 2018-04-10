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

import domain.DaneLogowania;
import domain.DaneRejestracji;
import repositories.InterfaceListaUzytRepozytorium;
import repositories.ListaUzytkownikowImplementacjaInterface;

@WebFilter("/loguj")
public class FiltrUzytkownikZwykly implements Filter {
	
	private DaneLogowania pobierzDaneLogowania(ServletRequest request){
		DaneLogowania result = new DaneLogowania();
		result.setUsername(request.getParameter("name"));
		result.setPassword(request.getParameter("password"));
		return result;
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		DaneLogowania tenUzytkownik = pobierzDaneLogowania(request);
		InterfaceListaUzytRepozytorium repozytorium = new ListaUzytkownikowImplementacjaInterface();
		boolean prawidloweHaslo = false;
		
		for(int i=0;i<(repozytorium.count());i++){
			if( ((tenUzytkownik.getUsername().equals(repozytorium.idUsername(i)))) &&
			    ((tenUzytkownik.getPassword().equals(repozytorium.idPassword(i)))) 
			  ){
				prawidloweHaslo = true;
				break;
			  }
			else{
				prawidloweHaslo = false;
			}
		}
		if(prawidloweHaslo == false){
			response.getWriter().println("Wprowadzono bledne dane logowania!");
			return;
		}
		
		chain.doFilter(request, response);
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}
}
