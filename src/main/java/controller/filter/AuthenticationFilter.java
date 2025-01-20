package controller.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.http.HttpRequest;

@WebFilter("front.do")
public class AuthenticationFilter extends HttpFilter implements Filter {
    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		HttpServletRequest httpReques = (HttpServletRequest)request;
		HttpSession session = httpReques.getSession(false);
		if (session != null && session.getAttribute("user") != null) {
			chain.doFilter(request, response);
			
		}else {
			request.setAttribute("message", "Acesso permitido apenas para usuário logado.");
			
			var dispatcher = request.getRequestDispatcher("front.do?action=getLoginForm");
			dispatcher.forward(request, response);
		}
		
		chain.doFilter(request, response);
	}

}
