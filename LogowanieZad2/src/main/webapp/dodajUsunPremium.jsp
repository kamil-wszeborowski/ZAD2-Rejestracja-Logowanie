<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Dodawanie uprawnień premium:</h1>
	<form action="dodajPremium" method="get">
		<label>Username:<input type="text" id="name" name="name"></label><br/>
 		<input type="submit" value="Dodaj Uprawnienia Premium" name="dodajPremium" >
	</form><br><br>
	<h1>Usuwanie uprawnień premium:</h1>
	<form action="usunPremium" method="get">
		<label>Username:<input type="text" id="name" name="name"></label><br/>
 		<input type="submit" value="Usun Uprawnienia Premium" name="usunPremium" >
	</form>
<p>---------------------------------------------------------------------------------------------------------------------</p>	
	<h1>Dodawanie uprawnień Administracyjnych:</h1>
	<form action="dodajAdmin" method="get">
		<label>Username:<input type="text" id="name" name="name"></label><br/>
 		<input type="submit" value="Dodaj Uprawnienia Administracyjne" name="dodajAdmin" >
	</form><br><br>
	<h1>Usuwanie uprawnień Administracyjnych:</h1>
	<form action="usunAdmin" method="get">
		<label>Username:<input type="text" id="name" name="name"></label><br/>
 		<input type="submit" value="Usun Uprawnienia Administracyjne" name="usunAdmin" >
	</form>
</body>
</html>