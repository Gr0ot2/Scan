<%@page import="proyecto.datos_caballos_clase"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="caballos_clase.css">
<title>Insert title here</title>
</head>
<body>
<%
Object obj= request.getSession().getAttribute("list");
ArrayList<datos_caballos_clase> list;
if (obj instanceof ArrayList<?>) {
    list = (ArrayList<datos_caballos_clase>) obj;
 %>
  <%for(datos_caballos_clase dato:list)  {%>
  <br></br>
  <h1 id="titulo">
  <strong> <%= dato.getNombre()%></strong>
  </h1>
	<div id="race">
 	RAZA
   <p><%= dato.getRaza()%></p>
   </div>
   <div id="layer"> 
	CAPA
   <p><%= dato.getCapa()%></p>
   </div>
   <%} %>
 <%} %>
</body>
</html>