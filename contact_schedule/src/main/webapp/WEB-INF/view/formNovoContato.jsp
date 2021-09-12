<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adicionar contato</title>
</head>
<body>
	
	<h1>Cadastro de contato</h1>
	
	<h2>Dados Contato</h2>
	<form action="${linkEntradaServlet }" method="post">
	
		Nome: <input type="text" name="nome"  /> <br><br>
		CPF: <input type="number" name="cpf"  /> <br><br>
		RG: <input type="number" name="rg"  /> <br><br>
		
		<h2>Dados Endereço</h2>
		
		Rua: <input type="text" name="rua"  /> <br><br>
		Número: <input type="number" name="numero"  /> <br><br>
		Complemento: <input type="text" name="complemento"  /> <br><br>
		Bairro: <input type="text" name="bairro"  /> <br><br>
		CEP: <input type="text" name="cep"  /> <br><br>
		Cidade: <input type="text" name="cidade"  /> <br><br>
		Estado: <input type="text" name="estado"  /> <br><br><br>
		
		<input type="hidden" name="acao" value="NovoContato">
		<input type="submit" value="Cadastrar" />
	</form>
</body>
</html>