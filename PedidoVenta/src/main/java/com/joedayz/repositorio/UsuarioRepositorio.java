package com.joedayz.repositorio;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.joedayz.modelo.Usuario;

public class UsuarioRepositorio implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Usuario buscarUsuarioporId(Long ideUsuario) {
		return this.manager.find(Usuario.class, ideUsuario);
	}

	public List<Usuario> listarVendedores() {
		return this.manager.createQuery("from Usuario", Usuario.class)
				.getResultList();
	}
	
	public Usuario buscarUsuarioporEmail(String email) {
		
		Usuario usuario = null;
		try{
			usuario =  this.manager.createQuery("from Usuario where lower(email) = :email", Usuario.class)
					.setParameter("email", email).getSingleResult();
		}catch(NoResultException e){
			
		}
		return usuario;
	}
	
}
