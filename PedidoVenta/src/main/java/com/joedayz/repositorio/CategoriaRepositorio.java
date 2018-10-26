package com.joedayz.repositorio;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.joedayz.modelo.Categoria;

public class CategoriaRepositorio implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager entityManager;
	
	public List<Categoria> listarCategorias(){
		return entityManager.createQuery("from Categoria where categoriaPadre is null ", 
				Categoria.class).getResultList();
	}
	
	public Categoria obtenerCategoria(Long id){
		return entityManager.find(Categoria.class, id);
	}
	
	public  List<Categoria> listarSubCategorias(Categoria categoriaPadre){
		return entityManager.createQuery("from Categoria where categoriaPadre = :categoriaPadre ", 
				Categoria.class).setParameter("categoriaPadre", categoriaPadre).getResultList();
	}
}
