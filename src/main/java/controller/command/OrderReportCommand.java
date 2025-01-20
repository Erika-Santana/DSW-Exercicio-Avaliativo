package controller.command;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.OrderDAOFactory;
import model.entity.Pedidos;

public class OrderReportCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse resp) {
		
		var dao = new OrderDAOFactory().factory();
		
		List<Pedidos> listaPedidos = dao.listarTodosPedidos();
		
		if (listaPedidos != null) {
			request.getSession(false).setAttribute("listaPedidos", listaPedidos);
		}
			return "/logged/paginaRelatorios.jsp";
	}

}
