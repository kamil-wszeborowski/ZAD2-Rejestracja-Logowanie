package web.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import domain.DaneLogowania;
import repositories.InterfaceListaUzytRepozytorium;
import repositories.ListaUzytkownikowImplementacjaInterface;


@WebServlet("")
public class FiltrDoDodawaniaUprawnienPremiumAdmin implements Filter {
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/*InterfaceListaUzytRepozytorium repozytorium = new ListaUzytkownikowImplementacjaInterface();
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession sessionAnonimowy = httpRequest.getSession();
		
		int i = (int) sessionAnonimowy.getAttribute("sesjaZalogowany");
		  if(((repozytorium.idUprPremium(i)) == false) &&
			 ((repozytorium.idUprAdmin(i)) == false)
			){ 
			
		  	}
		 */
		chain.doFilter(request, response);
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
