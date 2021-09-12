<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar Contato</title>
</head>
<body>

	<h1>Editar Contato</h1>

	<form action="${linkEntradaServlet }" method="post">
	
		Nome: <input type="text" name="nome" value="${contato.nome }" /> <br><br>
		RG: <input type="number" name="rg" value="${contato.rg }" /> <br><br>
		CPF: <input type="number" name="cpf" value="${contato.cpf }" /> <br><br>
		
		
		<input type="hidden" name="id" value="${contato.id }">
		<input type="hidden" name="acao" value="EditarContato">
		<input type="submit" value="Salvar"/>
	</form>

</body>
</html>