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


@WebServlet("/pr")
public class ProfilUzytkownika extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InterfaceListaUzytRepozytorium repozytorium = new ListaUzytkownikowImplementacjaInterface();
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		
		int i = (int) session.getAttribute("sesjaZalogowany");
	
		ServletOutputStream out = response.getOutputStream();
		out.println("<h1>");
		out.println("Twoj profil "+(repozytorium.idUsername(i))+" , twoje dane to:");
		out.println("</h1>");
		out.println("<br>");
		out.println("Username: "+(repozytorium.idUsername(i)));
		out.println("<br>");
		out.println("Password: "+(repozytorium.idPassword(i)));
		out.println("<br>");
		out.println("Email:"+(repozytorium.idEmail(i)));
		out.println("<br>");
		out.println("Premium: "+(repozytorium.idUprPremium(i)));
		out.println("<br>");
		out.println("Admin: "+(repozytorium.idUprAdmin(i)));
		out.println("<br><br>");
		
	}
}
