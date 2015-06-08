
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
			margin-left:30%;
			}
			th{
			border: 0.5em solid lightblue;
			color: black;
			
			}
			
			td{
			border: 1em solid blue;
			padding: 1em;
			
			}
			
			#btnSinBordes{
			border: 0em;
			background: transparent;
			text-decoration: undeline;
			}
			
		</style>


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
		<form action= "${pageContext.request.contextPath}/Tienda/BuscarPorId" method = "post"><!--for each y array(la c puede llamarse de cualquier forma-->
		<tr id = "<%= c.getId()%>">
			<td><input type ="text" name="Id" value = "<%= c.getId() %>" disabled ="disabled"/></td><!-- Para imprimir id, nombres, etc...como si fuera un 'syso'-->
			<td><%=c.getNombres() %></td>
			<td><%=c.getApellidos() %></td>
			<td><%=c.getDni() %></td>
			
			
			<td><input type = "submit" id = "btnSinBordes"  
			value = "Eliminar" name="btn<%= c.getId()%>"/></td>
			
		</tr>
		</form>
		<% } %>
		<!--  Las siguientes tr se construyen dinámicamente usando instrucciones java embebidas-->
	</table>
	
</body>
</html>