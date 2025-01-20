package controller.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetRegisterForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse resp) {

		return "/logged/register.jsp";
	}
}
