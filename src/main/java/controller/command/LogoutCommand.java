package controller.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LogoutCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse resp) {
		
		var session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		
		return "index.jsp";
	}

}
