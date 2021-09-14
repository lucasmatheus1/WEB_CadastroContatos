<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar Contato</title>
<style><%@include file="\WEB-INF\view\css\campos.css"%></style>
</head>
<body>

<div>
<h2>Editar Contato</h2>

	<form action="${linkEntradaServlet }" method="post">
	
		<input type="text" name="nome" placeholder="Nome" value="${contato.nome }" /> <br><br>
		<input type="number" name="rg" placeholder="RG" value="${contato.rg }" /> <br><br>
		<input type="number" name="cpf" placeholder="CPF" value="${contato.cpf }" /> <br><br>
		
		
		<input type="hidden" name="id" value="${contato.id }">
		<input type="hidden" name="acao" value="EditarContato">	
			
		
		<button type="submit">Salvar</button>
		<button type="button" name="back" onclick="history.back()">Voltar</button>
	</form>
</div>

	

</body>
</html>