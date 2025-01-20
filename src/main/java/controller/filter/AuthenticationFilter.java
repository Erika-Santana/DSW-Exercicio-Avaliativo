package controller.filter;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/*Filter responsável por interceptar qualquer requisição direcionada para o servlet(front.do) e todos os acessos
 * para as páginas jsp que estão na pasta "logged".
 * Caso o usuário tenha feito o Login e seja autenticado, ele vai poder ter acesso ao front.do, na qual está com todos os
 * commands para o processamento das ações do sistema e caso não, irá ser direcionado para o formulário de login*/

@WebFilter(urlPatterns={"/front.do", "/logged/*"})
public class AuthenticationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);

		if (session != null && session.getAttribute("user") != null) {
			chain.doFilter(request, response);
		} else {
			request.setAttribute("message", "Acesso permitido apenas para usuário logado.");

			var dispatcher = request.getRequestDispatcher("frontFilter.do?action=getLoginForm");
			dispatcher.forward(request, response);
		}

	}
}
