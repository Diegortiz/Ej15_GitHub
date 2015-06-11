
<%@page import="es.curso.model.entity.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

		<%@ include file="../Plantillas/Header.jsp" %>
		
		
		<script type= "text/javascript">
			
		
			function enviar(boton){
				var formulario = document.getElementById("formulario" + boton.name.substring(3));
				//Alterar el action de acuerdo al botón pulsado.
				if(boton.value =="Actualizar")
					formulario.action = 
						"${pageContext.request.contextPath}/Tienda/ActualizarCliente";
					
				if(boton.value == "Eliminar")
					formulario.action = 
						"${pageContext.request.contextPath}/Tienda/BuscarPorId";
			
					
			   formulario.submit();
					
			}
					
			
			
		</script>
		
		


	<h1><%=request.getAttribute("titulo") %></h1>
	<!-- Tabla html dinámicamente-->
	<span><%=LocalDateTime.now() %></span>
	<span>Valor enviado desde el servlet Tienda IVA:</span>
	<span><%=(Integer)request.getAttribute("iva")%></span>
	<% ArrayList<Cliente> clientes = (ArrayList<Cliente>)request.getAttribute("clientes"); %>
	
	<table>
	
		<tr>
			<th>ID:</th>
			<th>Nombre</th>
			<th>Apellidos</th>
			<th>DNI:</th>
			
		</tr>
		
		<%for (Cliente c: clientes){ %>
		<form id = "formulario<%= c.getId() %>" action= "#" method = "post"  onsubmit = "return false;"><!-- Onsubmit->Para evitar que el form se 'vaya' -->
			<!--for each y array(la c puede llamarse de cualquier forma-->
			<tr id = "<%= c.getId()%>">
				<td><input type ="text" name="Id" value = "<%= c.getId() %>" /></td><!-- Para imprimir id, nombres, etc...como si fuera un 'syso'-->
				<td><input type = "text" name ="nombres" value="<%=c.getNombres() %>" /></td>
				<td><input type = "text" name ="apellidos" value="<%=c.getApellidos() %>"/></td>
				<td><input type = "text" name = "dni" value="<%=c.getDni() %>"/></td>
				
				<td><input type = "submit" id = "btnSinBordes"  
				value = "Eliminar" name="btn<%= c.getId()%>"
				 onclick ="enviar(this);"/></td>
				
				<td><input type = "submit" id = "OtroBtn" 
				value = "Actualizar" name = "btn2<%= c.getId()%>"
				 onclick ="enviar(this);"/></td>
			
			
				<td><input type = "submit" id = "Btn3"
				value = "Editar" name = "btn3<%= c.getId()%>" 
				onclick = "enviar(this);"></td>
				
				
			</tr>
		</form>
		<% } %>
		<!--  Las siguientes tr se construyen dinámicamente usando instrucciones java embebidas-->
	</table>
	
	<%@ include file="../Plantillas/Footer.jsp" %>
		

				