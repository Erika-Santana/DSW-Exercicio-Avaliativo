<%@page import="model.entity.Pedidos"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/estilos.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>Alterar pedido</title>
</head>
<body>
	<jsp:include page="../includes/menu.jsp"/>
	<div class="index_container">
		<form action="front.do?action=alterOrder" method="post">
			<div class="titulos_form">
				<h2>Alterar pedido</h2>
				 <% 
						String mensagem = (String)request.getAttribute("message_alterOrder");
				 		Pedidos pedido = (Pedidos)request.getAttribute("pedido");
						if(mensagem != null && !mensagem.isEmpty()){		
								out.println("<h4> " + mensagem + "</h4>");
						}
					%>
			</div>
		  <div class="mb-3">
		  
		    <label for="cliente" class="form-label">Nome do Cliente:</label>
		    <input type="text" class="form-control" id="cliente" name="clientName" value="<%=pedido.getNomeCliente() %>" aria-describedby="cliente" required="required">
		  </div>
		  <div class="mb-3">
		    <label for="endereco" class="form-label">Endereço de entrega: </label>
		    <input type="text" class="form-control" value="<%=pedido.getEnderecoEntrega()%>" name="address" id="address" required="required">
		  </div>
		   <div class="mb-3">
		    <label for="exampleInputPassword1" class="form-label">Valor: </label>
		    <input type="text" class="form-control" name="price" value="<%=pedido.getValor() %>" id="price" required="required">
		  </div>
		   <div class="mb-3">
		    <label for="exampleInputPassword1" class="form-label">Descrição: </label>
		    <input type="text" class="form-control" name="description" value="<%=pedido.getDescricao() %>" id="description" required="required">
		  </div>
		  <input type="number" hidden="hidden" name="id" value="<%=pedido.getIdPedidos()%>"> 
		   <button type="submit" class="btn btn-secondary btn-lg">Alterar Pedido</button>
		</form>
	</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>