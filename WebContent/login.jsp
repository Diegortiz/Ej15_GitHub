<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



	<%@include file="../Plantillas/Header.jsp" %>
	
	<h2>Registrar usuario</h2>
	<form action="${pageContext.request.contextPath}/Tienda/login" method ="post">
	
	<label>Usuario: </label>
	<input  type = "text" name = "userName" id="Usuario" value = ""/>
	
	<label>Contraseña: </label>
	<input type = "password" name = "password" id ="Contraseña" value =""/>
	
	<input type ="submit" name="login" id="Enviar" value="Login"/>
	
	
	</form>
	<%@include file="../Plantillas/Footer.jsp" %>
