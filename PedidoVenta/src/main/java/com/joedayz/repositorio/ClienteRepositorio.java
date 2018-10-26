package com.joedayz.repositorio;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.joedayz.modelo.Cliente;

public class ClienteRepositorio implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Cliente buscarClienteporId(Long ideCliente) {
		return this.manager.find(Cliente.class, ideCliente);
	}

	public List<Cliente> buscarClienteporNombre(String nombreCliente) {
		return this.manager.createQuery("from Cliente " +
				"where upper(nombreCliente) like :nombreCliente", Cliente.class)
				.setParameter("nombreCliente", nombreCliente.toUpperCase() + "%")
				.getResultList();
	}
	
}
