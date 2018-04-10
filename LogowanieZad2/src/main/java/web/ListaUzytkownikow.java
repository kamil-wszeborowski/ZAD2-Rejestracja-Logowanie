package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repositories.InterfaceListaUzytRepozytorium;
import repositories.ListaUzytkownikowImplementacjaInterface;

@WebServlet("/li")
public class ListaUzytkownikow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InterfaceListaUzytRepozytorium repozytorium = new ListaUzytkownikowImplementacjaInterface();
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession sessionAnonimowy = httpRequest.getSession();
		int i;
			
		if(sessionAnonimowy.getAttribute("sesjaZalogowany")!=null){
			i = (int) sessionAnonimowy.getAttribute("sesjaZalogowany");
			if(	((repozytorium.idUprPremium(i)) == true) || ((repozytorium.idUprAdmin(i)) == true) || repozytorium.idUsername(i).equals("admin") ){
				
				ServletOutputStream out = response.getOutputStream();
				out.println("<h1>");
				out.println("Lista uzytkowników serwisu:");
				out.println("</h1>");
				for(int z=0;z<(repozytorium.count());z++){
					out.println((z)+". ");
					out.println("<br>");
					out.println("Username: "+(repozytorium.idUsername(z)));
					out.println("<br>");
					out.println("Email:"+(repozytorium.idEmail(z)));
					out.println("<br>");
					out.println("Premium: "+(repozytorium.idUprPremium(z)));
					out.println("<br>");
					out.println("Admin: "+(repozytorium.idUprAdmin(z)));
					out.println("<br><br>");
				}
			}
			else{
				response.getWriter().println("Nie masz uprawnien do ogladania listy uzytkownikow !");
				response.getWriter().println("Mozesz to obejsc zakladajac konto o loginie 'admin' !");
			 }
		 }
		else{
			response.sendRedirect("index.jsp");
		}	
	}
}
