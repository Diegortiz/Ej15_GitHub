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
			margin-left: 37%;
			margin-top: 10%;
			}
			th{
			border: 0.5em solid lightblue;
			color: black;
			}
			
			td{
			border: 1em solid blue;
			
			
			}
		</style>


</head>
<body>
	<!-- Tabla html dinámicamente-->
	<table>
		<tr>
			<th>ID:</th>
			<th>Nombre</th>
			<th>Apellidos</th>
			<th>DNI:</th>
		</tr>
		<!--  Las siguientes tr se construyen dinámicamente usando instrucciones java embebidas-->
	</table>
	
</body>
</html>