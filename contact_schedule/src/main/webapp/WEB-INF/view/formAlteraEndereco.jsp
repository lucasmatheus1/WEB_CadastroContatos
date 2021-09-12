<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar Endereço</title>
</head>
<body>

	<h1>Editar Endereço</h1>

	<form action="${linkEntradaServlet }" method="post">
	
		Rua: <input type="text" name="rua"  value="${endereco.rua }"/> <br><br>
		Número: <input type="number" name="numero"  value="${endereco.numero }"/> <br><br>
		Complemento: <input type="text" name="complemento"  value="${endereco.complemento }"/> <br><br>
		Bairro: <input type="text" name="bairro"  value="${endereco.bairro }"/> <br><br>
		CEP: <input type="text" name="cep"  value="${endereco.cep }"/> <br><br>
		Cidade: <input type="text" name="cidade"  value="${endereco.cidade }"/> <br><br>
		Estado: <input type="text" name="estado"  value="${endereco.estado }"/> <br><br><br>
				
		
		<input type="hidden" name="id" value="${endereco.id }">
		<input type="hidden" name="acao" value="EditarEndereco">
		<input type="submit" value="Salvar"/>
	</form>

</body>
</html>