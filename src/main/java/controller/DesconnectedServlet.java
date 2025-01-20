package controller;

import java.io.IOException;

import controller.command.Command;
import controller.command.GetLoginPageCommand;
import controller.command.LoginCommand;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/* Servlet responsável por processar as requisições redirecionadas pelo filter.
 * Aqui serão processadas as requisições de Home e de Login, que são os que qualquer usuário podem ter acesso.*/

@WebServlet("/frontFilter.do")
public class DesconnectedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);

	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Command command = null;
		String action = request.getParameter("action");

		if (action.equals("login")) {
			command = new LoginCommand();
		} else if (action.equals("getLoginForm")) {
			command = new GetLoginPageCommand();
		}

		String view = command.execute(request, response);

		var dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);

	}

}
