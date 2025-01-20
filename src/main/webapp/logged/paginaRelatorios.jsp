<%@page import="model.entity.Pedidos"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>

<html lang="en">
<head>
<link href="css/estilos.css" rel="stylesheet">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tabela de Clientes</title>
</head>
<body>

	<jsp:include page="../includes/menu.jsp"></jsp:include>
	
	
    <h1>Tabela de Pedidos</h1>
    
    
    <table>
        <thead>
            <tr>
                <th>ID Cliente</th>
                <th>Nome do Cliente</th>
                <th>Endereço de Entrega</th>
                <th>Valor</th>
                <th>Descrição</th>
                <th>Alterar</th>
                 <th>Excluir</th>
                   
            </tr>
        </thead>
        <tbody>
            <% 
              
                List<Pedidos> pedidos = (List<Pedidos>)session.getAttribute("listaPedidos");
            	if(pedidos != null && !pedidos.isEmpty()){
            		for(var pedidosLista : pedidos){
            			int idPedido = pedidosLista.getIdPedidos();
            			String nomeCliente = pedidosLista.getNomeCliente();
            			String enderecoEntrega = pedidosLista.getEnderecoEntrega();
            			float valor = pedidosLista.getValor();
            			String descricao = pedidosLista.getDescricao();
            		
                           
            %>
            <tr>
                <td><%= idPedido %></td>
                <td><%= nomeCliente %></td>
                <td><%= enderecoEntrega %></td>
                <td>R$ <%= String.format("%.2f", valor) %></td>
                <td><%= descricao %></td>
                <td><a href="front.do?action=alterOrderForm&id=<%= idPedido%>"><button type="button" class="btn btn-secondary btn-lg">Alterar</button></a></td>
                <td><a href="front.do?action=deleteOrder&id=<%= idPedido%>"><button type="button" class="btn btn-secondary btn-lg">Excluir</button></a></td>
            </tr>
            <% 
            		}
            	}else{
            %>
            <tr>
                <td colspan="5">Nenhum cliente encontrado.</td>
            </tr>
            <% 
                } 
            %>
        </tbody>
    </table>
</body>
</html>
