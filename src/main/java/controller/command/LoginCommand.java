package controller.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dao.DatabaseUserImp;
import model.entity.Usuario;

public class LoginCommand implements Command{
	
	private static DatabaseUserImp daoUser = new DatabaseUserImp();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse resp) {
	    var login = request.getParameter("login");
	    var senha = request.getParameter("senha");
	    

	    Usuario user = daoUser.encontrarUsuarioRegistrado(login);
	    
	    if (user != null) {
	        HttpSession session = request.getSession();
	        session.setAttribute("user", user);
	      
	        return "/logged/logged.jsp";
	    } else {
	        request.setAttribute("error_login", true);
	        return "login.jsp";
	    }
	    
	}
}