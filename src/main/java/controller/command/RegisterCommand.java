package controller.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.DatabaseUserImp;
import model.entity.Usuario;

public class RegisterCommand implements Command{
	private static DatabaseUserImp daoUser = new DatabaseUserImp();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse resp) {
		
		var senha = request.getParameter("senha");
		var login = request.getParameter("login");
		String mensagem = "";
		
		
		boolean resultado = daoUser.cadastrarNovoUsuario(new Usuario(login, senha));
		
		if (resultado) {
			mensagem = "Cadastro realizado com sucesso!";
		}else {
			mensagem = "Erro ao cadastrar!";
			
		}
		request.setAttribute("mensagem", mensagem);
	
		
		return "/logged/register.jsp";
	}

}