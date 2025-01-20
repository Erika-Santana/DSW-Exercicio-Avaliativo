package controller.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.OrderDAOFactory;
import model.dao.UserDAOFactory;
import model.entity.Pedidos;
import model.entity.Usuario;

public class RegisterOrderCommand implements Command {

	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse resp) {
		
		var nomeCliente = request.getParameter("clientName");
		var endereco = request.getParameter("address");
		var valor = request.getParameter("price");
		var descricao = request.getParameter("description");
		Usuario user = (Usuario) request.getSession().getAttribute("user");
		String mensagem = ""; 
		
		if (user != null) {
			var dao = new OrderDAOFactory().factory();
		
			Pedidos pedido = new Pedidos(nomeCliente, endereco, Long.parseLong(valor), descricao, user);
			boolean resultado = dao.cadastrarPedido(pedido);
			
			if (resultado) {
				mensagem = "Pedido cadastrado com sucesso!";
				request.setAttribute("message_order", mensagem);
			}else {
				mensagem = "Erro ao cadastrar pedido!";
				request.setAttribute("message_order", mensagem);
			}
			
		}else {
			mensagem = "Faça o login para cadastrar pedido!";
			
			return "index.jsp";
		}
		
		return "/logged/registerOrder.jsp";
	}

}
