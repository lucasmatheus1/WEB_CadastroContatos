<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<!-- <link href="css/login.css" rel="stylesheet"/> -->

<style>
	body{
		background-color: #c4e0f5;
	}
	
	div{
		text-align: center;
		margin: 0 auto;
		width: 50%;
	}
	
	div h2{
		font-family: Verdana, Arial, Helvetica, sans-serif;
	}
	
	input{
		width: 300px;
		height: 30px; 
		border-radius: 5px;
	}
	
	button{
		border-radius: 10px;
		font-family: Verdana, Arial, Helvetica, sans-serif;
		height: 30px; 
		background-color: red;
		color: white;
	}
	
	
</style>

</head>
<body>

<div>

<h2>Login</h2>
	
	<form action="${linkEntradaServlet }" method="post">
	
		<input type="text" name="login" placeholder="Nome"/> <br><br>
		<input type="password" name="senha" placeholder="Senha" /> <br><br>
		
		<input type="hidden" name="acao" value="Login">
	
		<button type="submit" class="botao" value="Login"> Entrar</button>
	</form>
	
</div>
	
	

</body>
</html>