package model.dao;


import java.util.List;

import model.entity.Pedidos;
import model.entity.Usuario;

public interface DatabaseUserDAO {
	/*Interface DAO de User*/
	public Usuario encontrarUsuarioRegistrado(String email);
	public boolean cadastrarNovoUsuario(Usuario user);

}