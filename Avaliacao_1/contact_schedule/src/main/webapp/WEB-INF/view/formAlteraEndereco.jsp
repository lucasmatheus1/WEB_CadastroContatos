<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar Endereço</title>
<style><%@include file="\WEB-INF\view\css\campos.css"%></style>
</head>
<body>

<div>
<h2>Editar Endereço</h2>

	<form action="${linkEntradaServlet }" method="post">
	
		<input type="text" name="rua" placeholder="Rua" value="${endereco.rua }"/> <br><br>
		<input type="number" placeholder="Número" name="numero"  value="${endereco.numero }"/> <br><br>
		<input type="text" placeholder="Complemento" name="complemento"  value="${endereco.complemento }"/> <br><br>
		<input type="text" placeholder="Bairro" name="bairro"  value="${endereco.bairro }"/> <br><br>
		<input type="text" placeholder="CEP" name="cep"  value="${endereco.cep }"/> <br><br>
		<input type="text" placeholder="Cidade" name="cidade"  value="${endereco.cidade }"/> <br><br>
		<input type="text" placeholder="Estado" name="estado"  value="${endereco.estado }"/> <br><br><br>
				
		<input type="hidden" name="id" value="${endereco.id }">
		<input type="hidden" name="acao" value="EditarEndereco">
				
		<button type="submit">Salvar</button>
		<button type="button" name="back" onclick="history.back()">Voltar</button>
	</form>
</div>

	

</body>
</html>