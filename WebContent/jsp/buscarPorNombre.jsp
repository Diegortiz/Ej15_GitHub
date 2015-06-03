<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Buscar por nombre</title>
		<style type="text/css">
			form{margin-left: 35%;
				margin-top: 10%;
				margin-bottom: 5%;
			}
			h2{
				margin-left:35%;
				
			}
			
			body{
				background-color: lightgreen;
				border:0.1em solid black;
			}
			
		</style>
</head>
<body>
	<H2>Buscar por nombre</H2>
	<form method = "get" action = "${pageContext.request.contextPath}/Tienda/buscarPorNombre" name="buscarPorNombre">
	
	<label>Nombre: </label>
	<input type= "text" name="nombre" id="nombre">
	<input type="submit" name= "enviar" value="Enviar"/>
	<input type= "reset" name="reiniciar" value="Reiniciar"/>
	
	</form>
	
</body>
</html>