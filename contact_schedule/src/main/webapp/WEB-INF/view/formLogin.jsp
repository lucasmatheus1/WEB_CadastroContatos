<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style><%@include file="\WEB-INF\view\css\campos.css"%></style>
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