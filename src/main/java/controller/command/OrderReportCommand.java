package controller.command;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.FabricOrderDAO;
import model.entity.Pedidos;

public class OrderReportCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse resp) {
		
		var dao = new FabricOrderDAO().factory();
		
		List<Pedidos> listaPedidos = dao.listarTodosPedidos();
		
		if (listaPedidos != null) {
			request.getSession(false).setAttribute("listaPedidos", listaPedidos);
		}
			return "paginaRelatorios.jsp";
	}

}
