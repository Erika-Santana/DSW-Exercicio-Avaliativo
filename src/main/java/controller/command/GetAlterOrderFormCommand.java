package controller.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.OrderDAOFactory;
import model.entity.Pedidos;

public class GetAlterOrderFormCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse resp) {
		var id = Integer.parseInt(request.getParameter("id"));
		var dao = new OrderDAOFactory().factory();
		
		Pedidos pedido = dao.retornaPedido(id);
		
		request.setAttribute("pedido", pedido);
		
		return "/logged/alterOrder.jsp";
	}

}
