<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, model.ContactModel"%>
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
	
	<ul>
		<c:forEach items="${contatos}" var="contato">
			
			<li>
				${contato.name }
				<a href="/contact_schedule/entrada?acao=EditarContato&id=${contato.id }">editar</a>
				<a href="/contact_schedule/entrada?acao=EditarEndereco&id=${contato.id }">endereços</a>
				<a href="/contact_schedule/entrada?acao=RemoveContato&id=${contato.id }">remover</a>
						
			</li>
		</c:forEach>
	</ul>
	
</body>
</html>