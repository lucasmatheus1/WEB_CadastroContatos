<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,model.Contato"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Endereços</title>

<style type="text/css">

h2{
	font-family: Verdana, Arial, Helvetica, sans-serif;
}

li{
	border-style: groove;
	height: 20px;
	list-style: none;
}

button{
	background-color: #1d195e;
	color: white;
}

</style>

</head>
<body>

<div>
<h2>ENDEREÇOS </h2> 

	<a href="/contact_schedule/entrada?acao=NovoEnderecoForm&id=${id }"><button>Adicionar</button></a>
	
	<ul>
		<c:forEach items="${enderecos}" var="endereco">
			
			<li>
				${endereco.rua } ,
				${endereco.numero }
				<a href="/contact_schedule/entrada?acao=MostrarEndereco&id=${endereco.id }"><img alt="Editar" src="assets/images/edit.jpg"></a>
				<a href="/contact_schedule/entrada?acao=RemoveEndereco&id=${endereco.id }"><img alt="Remover" src="assets/images/lixeira.jpg"></a>
				
						
			</li>
		</c:forEach>
	</ul>
</div>

<button onClick="history.go(-1)">Voltar</button>
	
	
	
</body>
</html>