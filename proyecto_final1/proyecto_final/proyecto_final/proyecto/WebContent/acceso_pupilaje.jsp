<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="acceso_pupilaje.css" type="text/css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<form action="acceso_pupilaje" method="post">
<div id="cuestionario">
<label id="label">NOMBRE USUARIOS</label>
<br><br>
<input name="user" type="text"/>
<br><br>
<label id="label">CONTRASEÑA</label>
<br><br>
<input name="password" type="password" id="contrasena"/>
<br></br>
 <input name="enviar" type="submit" class="button"/>
 <input name="eliminar" type="submit" value="eliminar" class="button"/>
 <input name="reset" type="reset" class="button"/> 
 </div>
</form>
<script src="password.js"></script>

</body>
</html>