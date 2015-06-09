package es.curso.controllers.ejb;

import es.curso.controllers.EncontrarPorIdController;
import es.curso.model.entity.Cliente;
import es.curso.persistence.model.dao.ClienteDao;
import es.curso.persistence.model.dao.jdbc.ClienteDaoJdbc;

public class EncontrarPorIdControllerEjb implements EncontrarPorIdController{

	@Override
	public void encontrar(Cliente cliente) {
		ClienteDao clienteDao = new ClienteDaoJdbc();
		
		Object Id = null;
		clienteDao.read(Id);
		
	}

	@Override
	public void encontrar(int id) {
		
		
	}

	public void buscar(int id) {
		
		
	}

}
