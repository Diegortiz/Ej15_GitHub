package es.curso.controllers;

import es.curso.model.entity.Cliente;

public interface EncontrarPorIdController {

	
	public void encontrar(Cliente cliente);
	
	public abstract void encontrar(int id);
	
	
}
