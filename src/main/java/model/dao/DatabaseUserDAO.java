package model.dao;


import java.util.List;

import model.entity.Pedidos;
import model.entity.Usuario;

public interface DatabaseUserDAO {

	public Usuario encontrarUsuarioRegistrado(String email);
	public boolean cadastrarNovoUsuario(Usuario user);

}