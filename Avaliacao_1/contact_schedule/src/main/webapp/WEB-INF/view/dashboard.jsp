
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
<style><%@include file="\WEB-INF\view\css\dashboard.css"%></style> 
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.1/css/all.css" crossorigin="anonymous">
</head>
<body>
<h1>${email}</h1>
<div>

<h2>CONTATOS </h2> 
	
	<a href="/contact_schedule/entrada?acao=NovoContatoForm"><button>Adicionar</button></a>
	
	<ul>
		<c:forEach items="${contatos}" var="contato">
			
			<li>
				${contato.nome }
		
				<div class="direita">
					<div class="item">
						<a href="/contact_schedule/entrada?acao=MostraContato&id=${contato.id }">
							<span style="color: Blue; aria-hidden="false"">
							  <i class="fas fa-edit"></i>
							</span>
						</a>
					</div>
					<div class="item">
						<a href="/contact_schedule/entrada?acao=Dashboard2&id=${contato.id }">
							<span style="color: Grey;">
							  <i class="fas fa-envelope"></i>
							</span>
						</a>
					</div>
					<div class="item">
						<a href="/contact_schedule/entrada?acao=RemoveContato&id=${contato.id }">
							<span style="color: Red;">
							  <i class="fas fa-trash"></i>
							</span>
						</a>
					</div>
				</div>
				
			</li>
		</c:forEach>
	</ul>
	
	
</div>
</body>
</html>
	
	