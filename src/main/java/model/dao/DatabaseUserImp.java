package model.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.dao.connection.DatabaseConnection;
import model.entity.Pedidos;
import model.entity.Usuario;

public class DatabaseUserImp implements DatabaseUserDAO{
	
	private static final String CRIAR_BANCO = "CREATE DATABASE prova";
	private static final String CREATE_TABLE_USER = "CREATE TABLE usuario(\n"
			+ "	login VARCHAR(50) NOT NULL,\n"
			+ "    senha VARCHAR(45)  NOT NULL,\n"
			+ "    \n"
			+ "    PRIMARY KEY (login)\n"
			+ ");\n";
	
	
	private static final String INSERT_USER = "INSERT INTO usuario(login, senha) VALUES(?, ?)";
	private static final String SELECT_USER = "SELECT * FROM usuario WHERE login = ?";
	
	
	public boolean cadastrarNovoUsuario(Usuario user) {
		
		if (user == null || user.getLogin() == null || user.getSenha() == null) {
	        throw new IllegalArgumentException("Usuário, login ou senha não podem ser nulos");
	    }
		
		int rows = 0;
		
		try (var connection = DatabaseConnection.getConnection();
					var preparedStatement = connection.prepareStatement(INSERT_USER)){
			
			preparedStatement.setString(1, user.getLogin());
			preparedStatement.setString(2, user.getSenha());
			rows = preparedStatement.executeUpdate();
			
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows > 0 ;
	}

	@Override
	public Usuario encontrarUsuarioRegistrado(String login) {
		Usuario user = null;
		
		try (var connection = DatabaseConnection.getConnection();
					var preparedStatement = connection.prepareStatement(SELECT_USER)){
			
			preparedStatement.setString(1, login);
			
			ResultSet resultado = preparedStatement.executeQuery();
			
			if (resultado.next()) {
				
				user = new Usuario(resultado.getString("login"), resultado.getString("senha"));	
			}
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
		
	}

	
	

}