<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Buscar por Id</title>
		
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
		<h2>Borrar cliente por Id</h2>
		<form method = "post" action="${pageContext.request.contextPath}/Tienda/BuscarPorId" 
		name= "BuscarPorId">
		
		<label>Id: </label>
		
		<input type = "text" name="Id" id="Id"/>
		<input type = "submit" name="borrar" value= "Borrar cliente"/>
		<input type = "reset" name="Borrar" value= "Reiniciar"/>
		</form>

	</body>
</html>
		
		
			