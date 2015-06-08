package es.curso.controllers.ejb;

import es.curso.controllers.BuscarPorIdController;
import es.curso.model.entity.Cliente;
import es.curso.persistence.model.dao.ClienteDao;
import es.curso.persistence.model.dao.jdbc.ClienteDaoJdbc;

public class BuscarPorIdControllerEjb implements BuscarPorIdController{

	
	@Override
	public void buscar(int id) {
		ClienteDao clienteDao = new ClienteDaoJdbc();
		//Verificar si no tiene deudas...
		clienteDao.delete(id);
		//Mandarle un correo al usuario diciéndole que fue dado de baja.
		
		
	}

	@Override
	public void borrar(Cliente cliente) {
		
		
	}
	

	
}


