package model.dao;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.dao.connection.DatabaseConnection;
import model.entity.Pedidos;
import model.entity.Usuario;

public class DatabasePedidosImp implements DatabasePedidosDAO{
	
	/*Classe concreta responsável por ser o reposítorio da Database dos Pedidos.
	 * irá guardar todas as operações que podem ser manipuladas dentro do banco de dados sobre os pedidos.
	 * Herda da interface DatabaseOrderDAO
	 * */
	
	
	private static final String CREATE_TABLE_PEDIDOS = "CREATE TABLE pedidos(\n"
			+ "	id_pedidos INT AUTO_INCREMENT,\n"
			+ "    nomeCliente VARCHAR(145) NOT NULL,\n"
			+ "    enderecoEntrega VARCHAR(200)  NOT NULL,\n"
			+ "    valor DECIMAL(10, 2) NOT NULL,\n"
			+ "    descricao VARCHAR(300) NOT NULL,\n"
			+ "    login VARCHAR(50) NOT NULL,\n"
			+ "    \n"
			+ "    PRIMARY KEY (id_pedidos),\n"
			+ "    FOREIGN KEY (login) REFERENCES usuario(login) ON DELETE CASCADE\n"
			+ "    ON UPDATE CASCADE \n"
			+ "    \n"
			+ ")";
	
	private static final String SELECT_PEDIDOS = "SELECT * FROM pedidos";
	private static final String SELECT_AN_ORDER = "SELECT * FROM pedidos WHERE id_pedidos = ?";
	private static final String SELECT_PEDIDOS_USER = "SELECT * FROM pedidos WHERE login = ?";
	private static final String INSERT_PEDIDOS = "INSERT INTO pedidos(nomeCliente, enderecoEntrega, valor, descricao, login) VALUES (?, ?, ?, ?, ?)";
	private static final String DELETE_PEDIDOS = "DELETE FROM pedidos WHERE id_pedidos = ?";
	private static final String DELETE_PEDIDOS_USER = "DELETE FROM pedidos WHERE login = ?";
	private static final String UPDATE_PEDIDOS = "UPDATE pedidos SET nomeCliente = ?,  enderecoEntrega  = ?, valor = ?, descricao = ?, login = ? WHERE id_pedidos = ?";
	private static final String UPDATE_PEDIDOS_USER = "UPDATE pedido SETnomeCliente = ?,  enderecoEntrega  = ?, valor = ?, descricao = ?, login = ?";
	public DatabaseUserImp databaseUser;
	
	public DatabasePedidosImp() {
		databaseUser = new DatabaseUserImp();
	}
	
	@Override
	public List<Pedidos> listarTodosPedidos() {
		List<Pedidos> listaPedidos = new LinkedList<Pedidos>();
		Pedidos pedido = null;
		Usuario user = null;
		
		try (var connection = DatabaseConnection.getConnection();
					var preparedStatement = connection.prepareStatement(SELECT_PEDIDOS)){
			
			var resultado = preparedStatement.executeQuery();
		
			while(resultado.next()) {
				var login = resultado.getString("login");
				user = databaseUser.encontrarUsuarioRegistrado(login);
				pedido = new Pedidos(resultado.getString("nomeCliente"), 
						resultado.getString("enderecoEntrega"), 
						resultado.getLong("valor"), 
						resultado.getString("descricao"),
						user);
				pedido.setIdPedidos(resultado.getInt("id_pedidos"));
			
				listaPedidos.add(pedido);
			}
			
				return listaPedidos;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	@Override
	public List<Pedidos> mostrarPedidoUsuario(Usuario user) {
		List<Pedidos> listaPedidos = new LinkedList<Pedidos>();
		Pedidos pedido = null;
		
		try (var connection = DatabaseConnection.getConnection();
				var preparedStatement = connection.prepareStatement(SELECT_PEDIDOS_USER)){
			
			preparedStatement.setString(1, user.getLogin());
			
			var resultado = preparedStatement.executeQuery();
			
			while(resultado.next()) {
				var login = resultado.getString("login");
				user = databaseUser.encontrarUsuarioRegistrado(login);
				pedido = new Pedidos(resultado.getString("nomeCliente"), 
						resultado.getString("enderecoEntrega"), 
						resultado.getLong("valor"), 
						resultado.getString("descricao"),
						user);
				pedido.setIdPedidos(resultado.getInt("id_pedidos"));
				
				listaPedidos.add(pedido);
			}
			
			return listaPedidos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean cadastrarPedido(Pedidos pedido){
		
		int row = 0;
		
		try(var connection = DatabaseConnection.getConnection();
				var preparedStatement = connection.prepareStatement(INSERT_PEDIDOS)){
			
			preparedStatement.setString(1, pedido.getNomeCliente());
			preparedStatement.setString(2, pedido.getEnderecoEntrega());
			preparedStatement.setLong(3, pedido.getValor());
			preparedStatement.setString(4, pedido.getDescricao());
			preparedStatement.setString(5, pedido.getUser().getLogin());
			
			row = preparedStatement.executeUpdate();
			
			return row > 0;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean deletarPedido(int IdPedido) {
		
			int row = 0;
					
			try(var connection = DatabaseConnection.getConnection();
					var preparedStatement = connection.prepareStatement(DELETE_PEDIDOS)){
				
				preparedStatement.setLong(1, IdPedido);
							
				row = preparedStatement.executeUpdate();
				
				return row > 0;
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			return false;
		}
	
	public boolean alterarPedido(int idPedido, Pedidos pedido) {
		int row = 0;
		
		try(var connection = DatabaseConnection.getConnection();
				var preparedStatement = connection.prepareStatement(UPDATE_PEDIDOS)){
			//UPDATE pedido SET nomeCliente = ?,  enderecoEntrega  = ?, valor = ?, descricao = ?, login = ? WHERE id_pedidos = ?
			preparedStatement.setString(1, pedido.getNomeCliente());
			preparedStatement.setString(2, pedido.getEnderecoEntrega());
			preparedStatement.setLong(3, pedido.getValor());
			preparedStatement.setString(4, pedido.getDescricao());
			preparedStatement.setString(5, pedido.getUser().getLogin());
			preparedStatement.setInt(6, idPedido);
						
			row = preparedStatement.executeUpdate();
			
			return row > 0;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	

	}
	
	public Pedidos retornaPedido(int idPedido) {
		int row = -1;
		Pedidos pedido = null;
		Usuario user = null;
		
		try(var connection = DatabaseConnection.getConnection();
				var preparedStatement = connection.prepareStatement(SELECT_AN_ORDER)){
			//UPDATE pedido SET nomeCliente = ?,  enderecoEntrega  = ?, valor = ?, descricao = ?, login = ? WHERE id_pedidos = ?
			preparedStatement.setInt(1, idPedido);
			var resultado = preparedStatement.executeQuery();
			
			while(resultado.next()) {
				var login = resultado.getString("login");
				user = databaseUser.encontrarUsuarioRegistrado(login);
				pedido = new Pedidos(resultado.getString("nomeCliente"), 
						resultado.getString("enderecoEntrega"), 
						resultado.getLong("valor"), 
						resultado.getString("descricao"),
						user);
				pedido.setIdPedidos(resultado.getInt("id_pedidos"));
				
				
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return pedido;

	}
	
}
