<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%@include file="../Plantillas/Header.jsp" %>
	<form method = "post" action = "${pageContext.request.contextPath}/Tienda/buscarPorNombre" name="buscarPorNombre">
	
	<h2>Buscar por nombre</h2>
	<label>Nombre: </label>
	<input type= "text" name="nombre" id="nombre">
	<input type="submit" name= "enviar" value="Enviar"/>
	<input type= "reset" name="reiniciar" value="Reiniciar"/>
	
	</form>
	<%@include file="../Plantillas/Footer.jsp" %>
