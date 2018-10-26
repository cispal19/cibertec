package com.joedayz.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.joedayz.modelo.Producto;
import com.joedayz.repositorio.ProductoRepositorio;
import com.joedayz.util.jpa.Transaccion;

public class RegistroProductoService implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private ProductoRepositorio productoRepositorio;
	
	@Transaccion
	public Producto registrarProducto(Producto producto){
		
		Producto productoExistente = productoRepositorio.obtenerProductoporSKU(producto.getSku());
		
		if(productoExistente!=null && !productoExistente.equals(producto)){
			throw new NegocioExcepciones("Ya existe un producto con ese SKU, verificar"); 
		}
		
		return productoRepositorio.adicionarProducto(producto);
	}

}
