<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adicionar endere�o</title>
<style><%@include file="\WEB-INF\view\css\campos.css"%></style>
</head>
<body>

<div>
<h2>Cadastro de endere�o</h2>
	<h3>Dados Endere�o</h3>
	<form action="${linkEntradaServlet }" method="post">
			
		
		<input type="text" placeholder="Rua" name="rua"  /> <br><br>
		<input type="number" placeholder="N�mero" name="numero"  /> <br><br>
		<input type="text" placeholder="Complemento" name="complemento"  /> <br><br>
		<input type="text" placeholder="Bairro" name="bairro"  /> <br><br>
		<input type="text" placeholder="CEP" name="cep"  /> <br><br>
		<input type="text" placeholder="Cidade" name="cidade"  /> <br><br>
		<input type="text" placeholder="Estado" name="estado"  /> <br><br><br>

		<input type="hidden" name="acao" value="NovoEndereco">
		
		<button type="submit">Cadastrar</button>
		<button type="button" name="back" onclick="history.back()">Voltar</button>
		
		
	</form>
</div>
	
	
</body>
</html>