package com.joedayz.repositorio.filtros;

import java.io.Serializable;

public class ProductoFiltros implements Serializable{

	private static final long serialVersionUID = 1L;

	private String sku;
	private String nombre;
	
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
