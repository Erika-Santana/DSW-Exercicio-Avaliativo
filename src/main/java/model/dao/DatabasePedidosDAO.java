package model.dao;

import java.util.List;

import model.entity.Pedidos;
import model.entity.Usuario;

public interface DatabasePedidosDAO {
	/*Interface DAO de Pedidos*/
	
	public List<Pedidos> listarTodosPedidos() ;
	public List<Pedidos> mostrarPedidoUsuario(Usuario user);
	public boolean cadastrarPedido(Pedidos pedido);
	public boolean deletarPedido(int IdPedido);
	public boolean alterarPedido(int idPedido, Pedidos pedido);
	public Pedidos retornaPedido(int idPedido);
	
}
