<%@page import="proyecto.datos_compra"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="resultado_compra.css" type="text/css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>USTED HA COMPRADO</h1>
<div id="resultado">
<%
Object obj= request.getSession().getAttribute("list");
ArrayList<datos_compra> list;
if (obj instanceof ArrayList<?>) {
    list = (ArrayList<datos_compra>) obj;
 %>
 <%for(datos_compra dato:list)  {%>
 <p> id:
<%= dato.getId() %></p>
 <p>producto:
 <%= dato.getProductos() %></p>
 <p>cantidad:
 <%= dato.getCantidad() %></p>
 <p>precio:
 <%= dato.getPrecio() %></p>
 <p>El precio final es de: 
 <%= dato.getPrecio_final() %></p>
 <%} %>
 <%} %>
 </div>
</body>
</html>