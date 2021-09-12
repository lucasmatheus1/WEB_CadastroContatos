<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adicionar contato</title>

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
<h2>Cadastro de contato</h2>
	
	<h3>Dados Contato</h3>
	<form action="${linkEntradaServlet }" method="post">
	
		<input type="text" placeholder="Nome" name="nome"  /> <br><br>
		<input type="number" placeholder="CPF" name="cpf"  /> <br><br>
		<input type="number" placeholder="RG" name="rg"  /> <br><br>
		
		<h3>Dados Endereço</h3>
		
		<input type="text" placeholder="Rua" name="rua"  /> <br><br>
		<input placeholder="Número" type="number" name="numero"  /> <br><br>
		<input type="text" placeholder="Complemento" name="complemento"  /> <br><br>
		<input type="text" placeholder="Bairro" name="bairro"  /> <br><br>
		<input type="text" placeholder="CEP" name="cep"  /> <br><br>
		<input type="text" placeholder="Cidade" name="cidade"  /> <br><br>
		<input type="text" placeholder="Estado" name="estado"  /> <br><br><br>
		
		<input type="hidden" name="acao" value="NovoContato">
		<button type="submit">Cadastrar</button>
	</form>
</div>
	
	
</body>
</html>