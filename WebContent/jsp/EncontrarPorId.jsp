<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../Plantillas/Header.jsp" %>
	<form method= "post" action ="${pageContext.request.contextPath}/Tienda/EncontrarPorId"
	name = "EncontrarPorId" >
	
	<h2>Buscar por Id</h2>
	<label>Id: </label>
	
	<input type = "text" name = "Id" id="Id"/>
	<input type = "submit" name="buscar" value= "Buscar"/>
	<input type = "reset" name="borrar" value= "Borrar"/>
	
	
	
	</form>

<%@include file="../Plantillas/Footer.jsp" %>











