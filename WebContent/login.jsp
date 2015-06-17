<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



	<%@include file="../Plantillas/Header.jsp" %>
	
	<h2>Login</h2>
	<form action="${pageContext.request.contextPath}/Tienda/login" method ="post">
	
	<label>Usuario: </label>
	<input  type = "text" name = "usuario" id="Usuario" value = ""/>
	
	<label>Contraseña: </label>
	<input type = "password" name = "contraseña" id ="Contraseña" value =""/>
	
	<input type ="submit" name="enviar" id="Enviar" value="Login"/>
	<input type = "reset" name ="borrar" id="Borrar" value="Borrar"/>
	
	</form>
	<%@include file="../Plantillas/Footer.jsp" %>
