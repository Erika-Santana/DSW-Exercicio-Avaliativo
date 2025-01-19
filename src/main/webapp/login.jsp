<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<meta charset="UTF-8">
<link rel="stylesheet" href="css/estilos.css">
<title>Login</title>
</head>
<body>
	<div class="index_container">
		<form action="front.do?action=login" method="post">
		  <div class="mb-3">
		   <% 
		    Boolean usuarioNaoLogado = (Boolean) request.getAttribute("error_login");
		    if (usuarioNaoLogado != null) {
			    	
						out.println("<div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\">");
						out.println("<h2> Conta inexistente! </h2>");
						out.println("<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
					
			    }
			%>

		    <label for="exampleInputEmail1" class="form-label">Login</label>
		    <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" required="required">
		  </div>
		  <div class="mb-3">
		    <label for="exampleInputPassword1" class="form-label">Senha</label>
		    <input type="password" class="form-control" name="senha" id="exampleInputPassword1" required="required">
		  </div>
		   <button type="submit" class="btn btn-secondary btn-lg">Entrar</button>
		</form>
	</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>