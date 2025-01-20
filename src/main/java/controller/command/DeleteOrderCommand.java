package controller.command;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.OrderDAOFactory;
import model.entity.Pedidos;

public class DeleteOrderCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse resp) {
		var id = Integer.parseInt( request.getParameter("id"));
		var daoPedido = new OrderDAOFactory().factory();
		
		daoPedido.deletarPedido(id);
		
		List<Pedidos> listaPedidos = daoPedido.listarTodosPedidos();
		
		if (listaPedidos != null) {
			request.getSession(false).setAttribute("listaPedidos", listaPedidos);
		}
		
		
		return "/logged/paginaRelatorios.jsp";
	}

}
