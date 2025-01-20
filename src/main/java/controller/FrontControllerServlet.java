package controller;

import java.io.IOException;

import controller.command.AlterOrderCommand;
import controller.command.Command;
import controller.command.DeleteOrderCommand;
import controller.command.GetAlterOrderFormCommand;
import controller.command.GetDeleteOrderFormCommand;
import controller.command.GetIndexCommand;
import controller.command.GetLoginPageCommand;
import controller.command.GetOrderReportCommand;
import controller.command.GetRegisterForm;
import controller.command.GetRegisterOrderFormCommand;
import controller.command.LoggedCommand;
import controller.command.LoginCommand;
import controller.command.LogoutCommand;
import controller.command.OrderReportCommand;
import controller.command.RegisterCommand;
import controller.command.RegisterOrderCommand;
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
		}else if(action.equals("getRegisterForm")) {
			command = new GetRegisterForm();
		}else if(action.equals("logged")) {
			command = new LoggedCommand();
		}else if(action.equals("getLoginForm")) {
			command = new GetLoginPageCommand();
		}else if(action.equals("register")) {
			command = new RegisterCommand();
		}else if(action.equals("registerOrderForm")) {
			command = new GetRegisterOrderFormCommand();
		}else if(action.equals("alterOrderForm")) {
			command = new GetAlterOrderFormCommand();
		}else if(action.equals("deleteOrderForm")) {
			command = new GetDeleteOrderFormCommand();
		}else if(action.equals("logout")) {
			command = new LogoutCommand();
		}else if(action.equals("getOrderReport")) {
			command = new GetOrderReportCommand();
		}else if(action.equals("home")) {
			command = new GetIndexCommand();
		}else if(action.equals("orderReport")) {
			command = new OrderReportCommand();
		}else if(action.equals("deleteOrder")) {
			command = new DeleteOrderCommand();
		}else if(action.equals("alterOrder")) {
			command = new AlterOrderCommand();
		}else if(action.equals("registerOrder")) {
			command = new RegisterOrderCommand();
		}	
		

		String view = command.execute(request, response);
		
		var dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
				
		
	}
}
