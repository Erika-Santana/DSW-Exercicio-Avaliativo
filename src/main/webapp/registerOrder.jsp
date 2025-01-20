<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/estilos.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>Criar Pedido</title>
</head>
<body>
	<jsp:include page="includes/menu.jsp"/>
	<div class="index_container">
		<form action="front.do?action=registerOrder" method="post">
			<div class="titulos_form">
				<h2>Criar pedido</h2>
				  <% 
						String mensagem = (String)request.getAttribute("message_order");
						if(mensagem != null && !mensagem.isEmpty()){
										
								out.println("<div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\">");
								out.println("<h4> " + mensagem + "</h4>");
								out.println("<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
						}
					%>
			</div>
		  <div class="mb-3">
		    <label for="cliente" class="form-label">Nome do Cliente:</label>
		    <input type="text" class="form-control" id="cliente" name="clientName" aria-describedby="cliente" required="required">
		  </div>
		  <div class="mb-3">
		    <label for="endereco" class="form-label">Endereço de entrega: </label>
		    <input type="text" class="form-control" name="address" id="address" required="required">
		  </div>
		   <div class="mb-3">
		    <label for="exampleInputPassword1" class="form-label">Valor: </label>
		    <input type="text" class="form-control" name="price" id="price" required="required">
		  </div>
		   <div class="mb-3">
		    <label for="exampleInputPassword1" class="form-label">Descrição: </label>
		    <input type="text" class="form-control" name="description" id="description" required="required">
		  </div>
		   <button type="submit" class="btn btn-secondary btn-lg">Criar pedido</button>
		</form>
	</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>