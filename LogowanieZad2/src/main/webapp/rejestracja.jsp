<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rejestracja</title>
</head>
<body>
 <h1>Strona Rejestracji !!!</h1>
 <form action="rejestruj" method="get">
 	<label>Username:<input type="text" id="name" name="name"></label><br/>
 	<label>Password:<input type="text" id="password" name="password"></label><br/>
 	<label>Confirm password:<input type="text" id="con_password" name="con_password"></label><br/>
 	<label>Email:<input type="text" id="email" name="email"></label><br/>
 	<input type="submit" value="Zarejestruj" name="zarejestruj" >
 </form>
</body>
</html>