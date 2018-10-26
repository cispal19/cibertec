package com.joedayz.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.joedayz.modelo.Producto;
import com.joedayz.repositorio.ProductoRepositorio;
import com.joedayz.repositorio.filtros.ProductoFiltros;
import com.joedayz.util.FacesUtil;

@Named
@ViewScoped
public class ProductoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProductoRepositorio productoRepositorio;
	
	private List<Producto> productosFiltrados;
	private ProductoFiltros filtros;
	
	private Producto productoSeleccionado;
	
	public Producto getProductoSeleccionado() {
		return productoSeleccionado;
	}

	public void eliminarProducto(){
		productoRepositorio.removerProducto(productoSeleccionado);
		productosFiltrados.remove(productoSeleccionado);
		FacesUtil.adicionarMensajeInfo("Producto "+productoSeleccionado.getSku() +" eliminado.");
	}
	
	public void setProductoSeleccionado(Producto productoSeleccionado) {
		this.productoSeleccionado = productoSeleccionado;
	}

	public ProductoBean(){
		filtros = new ProductoFiltros();
	}
	
	public void buscarProductosFiltros(){
		productosFiltrados = productoRepositorio.listarProductosFiltrados(filtros);
	}

	
	public List<Producto> getProductosFiltrados() {
		return productosFiltrados;
	}


	public ProductoFiltros getFiltros() {
		return filtros;
	}
	
	
}
