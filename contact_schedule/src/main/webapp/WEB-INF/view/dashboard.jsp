<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,model.Contato"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
	
	Contatos: <br />
	<br />
	<a href="/contact_schedule/entrada?acao=NovoContatoForm">Adicionar</a>
	
	<ul>
		<c:forEach items="${contatos}" var="contato">
			
			<li>
				${contato.nome }
				<a href="/contact_schedule/entrada?acao=MostraContato&id=${contato.id }">editar</a>
				<a href="/contact_schedule/entrada?acao=Dashboard2&id=${contato.id }">endereços</a>
				<a href="/contact_schedule/entrada?acao=RemoveContato&id=${contato.id }">remover</a>
						
			</li>
		</c:forEach>
	</ul>
	
</body>
</html>