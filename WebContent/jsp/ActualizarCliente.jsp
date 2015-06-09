<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Buscar y actualizar cliente</title>
			<style type="text/css">
				form{
					
					margin-left: 35%;
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
	
	<h2>Buscar cliente y actualizarlo </h2>
		<form action = "${pageContext.request.contextPath}/Tienda/ListarTodos.jsp" method = "post" enctype = "text/html">
		
		
		<label>Id: </label>
			
		<input type="text" name="Identificador" id="identificador" value="" required="required"/>
		<br/><br/><br/><br/>
		
		
		<br/><br/><br/><br/>
		
		<input type = "hidden" name="id" id="id"/>
		
		<br/><br/><br/><br/>
		
		<input type="submit" id="Buscar" name="buscar" value="Buscar"/>
		<input type="reset" id="borrar" name="borrar" value="Borrar"/>
		
		
		</form>
	
	</body>
	
</html>
			
		
		
	
	
	
			


