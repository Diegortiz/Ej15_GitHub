package es.curso.controllers.ejb;

import es.curso.controller.DarAltaClienteController;
import es.curso.model.entity.Cliente;
import es.curso.persistence.model.dao.ClienteDao;
import es.curso.persistence.model.dao.jdbc.ClienteDaoJdbc;

public class DarAltaClienteControllerEjb implements DarAltaClienteController{

	private ClienteDao clienteDao;
	
	@Override
	public void agregar(Cliente cliente) {
		// Lógica del negocio para agregar un cliente
		//1. Verificar datos
		//2. Agregarlo -->LLamar a lacapa dao-- para que se de de alta
		//3. Enviar e-mail al jefe de obra
		//4. Enviar un e-mail al cliente
		clienteDao = new ClienteDaoJdbc();
		clienteDao.create(cliente);
		
		
	}

}
	
	
