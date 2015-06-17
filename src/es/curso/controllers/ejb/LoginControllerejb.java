package es.curso.controllers.ejb;

import es.curso.controllers.LoginController;
import es.curso.model.entity.Usuario;
import es.curso.persistence.model.dao.usuarioDao;
import es.curso.persistence.model.dao.jdbc.UsuarioDaoJdbc;

public class LoginControllerejb implements LoginController {

	@Override
	public Usuario login(String userName, String password) {
		usuarioDao usuarioDao = new UsuarioDaoJdbc();
		
		return usuarioDao.searchForUserNamePassword(userName, password);
		
	}

}
