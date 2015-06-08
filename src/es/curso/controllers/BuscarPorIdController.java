package es.curso.controllers;

import es.curso.model.entity.Cliente;

public interface BuscarPorIdController {

	public void borrar(Cliente cliente);

	public abstract void buscar(int id);
	
	
	
}
