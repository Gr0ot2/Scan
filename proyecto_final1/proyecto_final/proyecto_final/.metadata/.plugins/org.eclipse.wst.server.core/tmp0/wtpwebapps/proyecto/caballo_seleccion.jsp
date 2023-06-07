<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="caballos_seleccion.css" type="text/css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="caballos_seleccionCM" method="post">
<label id="label">¿Que caballo quieres ver Marengo o Capricho?</label>
<br></br>
<input id="radio" type="radio" name="escoja" value="Marengo"><label>Marengo</label> 
<input id="radio" type="radio" name="escoja" value="Capricho"><label>Capricho</label> 
<br></br>
 <input name="enviar" type="submit"/>
</form>
</body>
</html>