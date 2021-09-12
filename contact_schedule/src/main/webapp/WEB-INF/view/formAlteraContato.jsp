<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar Contato</title>

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
<h2>Editar Contato</h2>

	<form action="${linkEntradaServlet }" method="post">
	
		<input type="text" name="nome" placeholder="Nome" value="${contato.nome }" /> <br><br>
		<input type="number" name="rg" placeholder="RG" value="${contato.rg }" /> <br><br>
		<input type="number" name="cpf" placeholder="CPF" value="${contato.cpf }" /> <br><br>
		
		
		<input type="hidden" name="id" value="${contato.id }">
		<input type="hidden" name="acao" value="EditarContato">		
		
		<button type="submit">Salvar</button>
	</form>
</div>

	

</body>
</html>