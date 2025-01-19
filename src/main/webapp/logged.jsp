<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Aeroporto</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
		
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
				<a class="navbar-brand" href="FrontControllerServlet?action=home">Home</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNav"
					aria-controls="navbarNav" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" href="front.do?action=registrarPedido">Registrar Pedido</a></li>
						<li class="nav-item"><a class="nav-link" href="front.do?action=deletarPedido">Deletar Pedido</a></li>
						<li class="nav-item"><a class="nav-link" href="front.do?action=alterarPedido"> Alterar Pedido</a></li>
						<li class="nav-item"><a class="nav-link" href="front.do?action=relatorioPedido"></a>Consultar</li>
						<li class="nav-item"><a class="btn btn-warning" href="front.do?action=logout">Logout</a></li>
					</ul>
				</div>
			</div>
		</nav>
	
	<div class="container text-center">
		<img alt="" src="../images/profile_image.png">
	</div>




	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>