package controller;

import java.io.IOException;

import controller.command.Command;
import controller.command.GetLoginPageCommand;
import controller.command.LoggedCommand;
import controller.command.LoginCommand;
import controller.command.RegisterCommand;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/front.do")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
		super.doGet(req, resp);
	}
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Command command = null;
		String action = request.getParameter("action");
		
		if (action.equals("login")) {
				command = new LoginCommand();
			}else{if(action.equals("register")) {
				command = new RegisterCommand();
			}else {if(action.equals("logged")) {
				command = new LoggedCommand();
			}else {	if(action.equals("getLoginForm")) {
				command = new GetLoginPageCommand();
			}		
		}			
		}
		
		
		String view = command.execute(request, response);
		var dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
				
		
	}
	}
}