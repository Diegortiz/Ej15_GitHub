package es.curso.controllers.ejb;

import es.curso.controllers.BuscarPorIdController;
import es.curso.model.entity.Cliente;
import es.curso.persistence.model.dao.ClienteDao;
import es.curso.persistence.model.dao.jdbc.ClienteDaoJdbc;

public class BuscarPorIdControllerEjb implements BuscarPorIdController{

	

	public void borrar(int id) {
		ClienteDao clienteDao = new ClienteDaoJdbc();
		
		clienteDao.delete(id);
		
		
	}

	@Override
	public void borrar(Cliente cliente) {
		
		
	}

	@Override
	public void buscar(int id) {
		
		
	}
	

	
}


