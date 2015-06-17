package es.curso.persistence.model.dao;

import es.curso.model.entity.Usuario;

public interface usuarioDao {


	public Usuario searchForUserNamePassword(String userName, String password);
}
