package es.curso.persistence.model.dao.jdbc;

import java.util.ArrayList;

import es.curso.model.entity.Cliente;
import es.curso.persistence.model.dao.ClienteDao;

public class ClienteDaoJdbc implements ClienteDao{
	private ArrayList<Cliente> clientes;
	
	
	public ClienteDaoJdbc() {
		super();
		clientes = new ArrayList<Cliente>();
	}

	@Override
	public void create(Cliente cliente) {
		//Van las instrucciones para
		//1. Conectar con la base de datos.
		//2. Preparar la sentencia -sql- para agregar.
		//3. Ejecutar la sentencia -sql-
		//4.Cerrar la conexi�n.
		clientes.add(cliente);
		
	}

	@Override
	public ArrayList<Cliente> findAll() {
		
		clientes.add(new Cliente(1, "Jos�", "P�rez", "1234D"));
		clientes.add(new Cliente(2, "Mar�a", "C�ceres", "65657E"));
		clientes.add(new Cliente(3, "Rosa", "Mart�nez", "54633B"));
		clientes.add(new Cliente(4, "Rafael", "Rodr�guez", "88888H"));
		clientes.add(new Cliente(5, "Almudena", "Garc�a", "76767G"));
		clientes.add(new Cliente(6, "�scar", "Pe�alver", "73737K"));
		clientes.add(new Cliente(7, "Teresa", "Jim�nez", "63626R"));
		return clientes;
		
	}

}
	
	
