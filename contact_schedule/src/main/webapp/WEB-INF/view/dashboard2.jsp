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
</head>
<body>
	
	Endereços: <br />
	<br />
	<a href="/contact_schedule/entrada?acao=NovoEnderecoForm&id=${id }">Adicionar</a>
	
	<ul>
		<c:forEach items="${enderecos}" var="endereco">
			
			<li>
				${endereco.rua } ,
				${endereco.numero } -
				<a href="/contact_schedule/entrada?acao=MostrarEndereco&id=${endereco.id }">editar</a>
				<a href="/contact_schedule/entrada?acao=RemoveEndereco&id=${endereco.id }">remover</a>
				
						
			</li>
		</c:forEach>
	</ul>
	
</body>
</html>