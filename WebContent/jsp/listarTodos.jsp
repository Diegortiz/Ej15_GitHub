
<%@page import="es.curso.model.entity.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado de cliente</title>
		<style type="text/css">
			
			
			table{
			border: 0.1em solid blue;
			margin-left: 1%;
			}
			th{
			border: 0.5em solid lightblue;
			color: black;
			
			}
			
			td{
			border: 1em solid blue;
			padding: 0.5em;
			
			}
			
			#btnSinBordes{
			border: 0em;
			background: transparent;
			text-decoration: undeline;
			}
			
			#OtroBtn{
			border: 0em;
			background: transparent;
			text-decoration: undeline;
			}
			
			#Btn3{
			border: 0em solid: black;
			
			text-decoration: undeline;
			}
			
		</style>
		
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
			
					
				//if(boton.value =="Editar")
					//formulario.action =
						//"${pageContext.request.contextPath}/Tienda/ActualizarCliente";
			
					//formulario.submit();
					
			}
					
			
			
		</script>
		
		
</head>
<body>
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
	
</body>
</html>
		
		

				