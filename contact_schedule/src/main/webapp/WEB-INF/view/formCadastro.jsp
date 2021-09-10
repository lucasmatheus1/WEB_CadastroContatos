<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro</title>
</head>
<body>

	<h1>Cadastro</h1>

	<form action="${linkEntradaServlet }" method="post">
	
		Nome: <input type="text" name="nome"  />
		E-mail: <input type="text" name="email"  />
		Senha: <input type="password" name="senha"  />
		
		<input type="hidden" name="acao" value="Cadastro">
	
		<input type="submit" value="Cadastrar"/>
	</form>

</body>
</html>