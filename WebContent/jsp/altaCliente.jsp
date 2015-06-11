<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../Plantillas/Header.jsp" %>

	<h2>Alta cliente</h2>
    <form action="/Ej15_GitHub/Tienda/altaCliente" method="post" enctype="text/html">
		<label>Nombre: </label>
		<input type="text" name="nombres" id="nombres" value="" required="required"/>
		<br/><br/><br/><br/>
		
		<labe>Apellidos: : </label>
		<input type="text" name="apellidos" id="apellidos" value="" required="required"/>
		<br/><br/><br/><br/>
		
		<label>DNI: </label>
		<input type="text" name="dni" id="dni">
			
		<br/><br/><br/><br/>
		
		<input type = "hidden" name="id" id="id"/>
		
		<br/><br/><br/><br/>
		
		<input type="submit" id="enviar" name="enviar" value="Enviar"/>
		<input type="reset" id="borrar" name="borrar" value="Borrar"/>
		
		</form>
		
<%@include file="../Plantillas/Footer.jsp" %>