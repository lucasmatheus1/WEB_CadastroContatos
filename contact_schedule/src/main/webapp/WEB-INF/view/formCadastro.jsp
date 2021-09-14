<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro</title>
<style><%@include file="\WEB-INF\view\css\campos.css"%></style>
</head>
<body>

<div>
<h2>Cadastro</h2>

	<form action="${linkEntradaServlet }" method="post">
	
		<input type="text" name="nome" placeholder="Nome" /> <br><br>
		<input type="text" name="email" placeholder="E-mail" /> <br><br>
		<input type="password" name="senha" placeholder="Senha" /> <br><br>
		
		<input type="hidden" name="acao" value="Cadastro"> 
	
		<button type="submit">Cadastrar</button>
		<button type="button" name="back" onclick="history.back()">Voltar</button>
	</form>
</div>

	

</body>
</html>