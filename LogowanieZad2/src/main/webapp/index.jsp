<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Strona Startowa</title>
</head>
<body>
 <form action="start" method="get">
  <h1>Strona startowa !!!</h1>
 </form>
 
	 <form action="r" method="get">
	 	<input type="submit" value="Rejestracja" name="rejestracja">
	 </form><br>
	 <form action="l" method="get">
	 	<input type="submit" value="Logowanie" name="logowanie" >
	 </form><br> 
 <% 
 HttpServletRequest httpRequest = (HttpServletRequest) request;
 HttpSession sessionAnonimowy = httpRequest.getSession();
 if((sessionAnonimowy.getAttribute("sesjaZalogowany")!=null)){ 
 %>
 	 <form action="d" method="get">
 		<input type="submit" value="Dodaj/Usun Uprawnienia Premium" name="dodajPremium" >
 	 </form> <br>
 	 
 	 <form action="pr" method="get">
 		<input type="submit" value="Profil uzytkownika" name="profilUzytkownika">
 	 </form><br>
   
	 <form action="p1" method="get">
	 	<input type="submit" value="Podstrona Premium" name="podstrona">
	 </form><br>
	  
 	  <form action="li" method="get">
		 	<input type="submit" value="Lista Uzytkownikow" name="lista" >
	 </form><br>
	 
	  <form action="w" method="get">
 		<input type="submit" value="Wyloguj" name="wyloguj">
 	 </form><br> 	
  <% }; %>	


</body>
</html>