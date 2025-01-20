package controller.command;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.FabricOrderDAO;
import model.entity.Pedidos;

public class DeleteOrderCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse resp) {
		var id = Integer.parseInt( request.getParameter("id"));
		var daoPedido = new FabricOrderDAO().factory();
		
		daoPedido.deletarPedido(id);
		
		List<Pedidos> listaPedidos = daoPedido.listarTodosPedidos();
		
		if (listaPedidos != null) {
			request.getSession(false).setAttribute("listaPedidos", listaPedidos);
		}
		
		
		return "paginaRelatorios.jsp";
	}

}
