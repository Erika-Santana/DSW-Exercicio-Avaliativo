package controller.command;

import java.util.List;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.OrderDAOFactory;
import model.entity.Pedidos;
import model.entity.Usuario;

public class AlterOrderCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse resp) {
		
		var id = request.getParameter("id");
		var nomeCliente = request.getParameter("clientName");
		var endereco = request.getParameter("address");
		var valor = request.getParameter("price");
		var descricao = request.getParameter("description");
		Usuario user = (Usuario) request.getSession().getAttribute("user");
		String mensagem = ""; 
		
		if (user != null) {
			var dao = new OrderDAOFactory().factory();
		
			Pedidos pedido = new Pedidos(nomeCliente, endereco, Long.parseLong(valor), descricao, user);			
			boolean resultado = dao.alterarPedido(Integer.parseInt(id), pedido);
			
			if (resultado) {
				mensagem = "Pedido alterado com sucesso!";
				request.setAttribute("message_alterOrder", mensagem);
			}else {
				mensagem = "Erro ao alterar pedido!";
				request.setAttribute("message_alterOrder", mensagem);
			}
			
			List<Pedidos> listaPedidos = dao.listarTodosPedidos();
			request.getSession(false).setAttribute("listaPedidos", listaPedidos);
			
		}else {
			mensagem = "Faça o login para alterar pedido!";
			
			return "index.jsp";
		}
		
		return "/logged/paginaRelatorios.jsp";
	}

}
