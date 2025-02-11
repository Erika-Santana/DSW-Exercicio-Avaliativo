package model.entity;

import java.util.LinkedList;
import java.util.List;

public class Usuario {
	private String login;
	private String senha;
	private List<Pedidos> listaPedidos;
	
	public Usuario(Usuario user) {
		login = user.login;
		senha = user.senha;
		listaPedidos = new LinkedList<Pedidos>();
	}
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	public Usuario(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	 
	public boolean addPedido(Pedidos pedido) {
		
		listaPedidos.add(pedido);
		return true;
	}
}