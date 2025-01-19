package model.dao;

import java.util.List;

import model.entity.Pedidos;
import model.entity.Usuario;

public interface DatabasePedidosDAO {

	public List<Pedidos> listarTodosPedidos() ;
	public List<Pedidos> mostrarPedidoUsuario(Usuario user);
	public boolean cadastrarPedido(Pedidos pedido);
	
}
