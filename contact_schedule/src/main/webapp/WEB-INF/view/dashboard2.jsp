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
<style><%@include file="\WEB-INF\view\css\dashboard.css"%></style>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.1/css/all.css" crossorigin="anonymous">
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
				
				<div class="direita">
					<div class="item">
						<a href="/contact_schedule/entrada?acao=MostrarEndereco&id=${endereco.id}">
							<span style="color: Blue;">
							  <i class="fas fa-edit"></i>
							</span>
						</a>
					</div>
					<div class="item">
						<a href="/contact_schedule/entrada?acao=RemoveEndereco&id=${endereco.id}">
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

<a href="/contact_schedule/entrada?acao=Dashboard"><button>Voltar</button></a>
	
</body>
</html>