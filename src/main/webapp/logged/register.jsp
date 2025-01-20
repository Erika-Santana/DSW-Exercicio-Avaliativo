<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/estilos.css" rel="stylesheet" >
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>Registre-se</title>
</head>
<body>

<jsp:include page="../includes/menu.jsp"></jsp:include>
 <div class="index_container">
       
        <% 
			String mensagem = (String)request.getAttribute("mensagem");
			if(mensagem != null && !mensagem.isEmpty()){
							
					
					out.println("<h2> " + mensagem + "</h2>");
					
			}
		%>
        <div>
            <form action="front.do?action=register" method="post">
                <div class="mb-3"> 
                <h2 >Registre-se</h2>
                    <label for="email" class="form-label">Login</label>
                    <input type="email" class="form-control" id="login" name="login" aria-describedby="emailHelp" required="required">
                </div>
                <div class="mb-3">
                    <label for="senha" class="form-label">Senha</label>
                    <input type="password" class="form-control" id="senha" name="senha" required="required">
                </div>
                <button type="submit" class="btn btn-secondary btn-lg">Registre-se</button>
            </form>
        </div>
    </div>
    
   
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>