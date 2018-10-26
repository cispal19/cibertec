package com.joedayz.repositorio;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.joedayz.modelo.Producto;
import com.joedayz.repositorio.filtros.ProductoFiltros;
import com.joedayz.service.NegocioExcepciones;
import com.joedayz.util.jpa.Transaccion;

public class ProductoRepositorio implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;
	
	public Producto adicionarProducto(Producto producto){
		return entityManager.merge(producto);
	}
	
	@Transaccion
	public void removerProducto(Producto producto){
		try{
			producto = obtenerProducto(producto.getIdeProducto());
			entityManager.remove(producto);
			entityManager.flush();
		}catch(PersistenceException e){
			throw new NegocioExcepciones("El producto no puede ser eliminado.");
		}
	}
	
	public Producto obtenerProductoporSKU(String sku){
		try{
			return entityManager.createQuery("from Producto where upper(sku) = :sku", Producto.class)
					.setParameter("sku", sku.toUpperCase())
					.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Producto> listarProductosFiltrados(ProductoFiltros productoFiltros){
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria =  session.createCriteria(Producto.class);
		if(StringUtils.isNotBlank(productoFiltros.getSku())){
			criteria.add(Restrictions.eq("sku", productoFiltros.getSku()));
		}
		
		if(StringUtils.isNotBlank(productoFiltros.getNombre())){
			criteria.add(Restrictions.ilike("nombreProducto", productoFiltros.getNombre(), 
							MatchMode.ANYWHERE));
		}
		
		return criteria.addOrder(Order.asc("nombreProducto")).list();
	}
	
	public Producto obtenerProducto(Long id){
		return entityManager.find(Producto.class, id);
	}
	
	public List<Producto> obtenerProductoporNombre(String nombreProducto){
		return this.entityManager.createQuery("from Producto where upper(nombreProducto) like :nombreProducto", 
				Producto.class).setParameter("nombreProducto", nombreProducto.toUpperCase() + "%").getResultList();
	}
	
}
