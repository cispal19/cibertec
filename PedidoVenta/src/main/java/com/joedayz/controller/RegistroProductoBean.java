package com.joedayz.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.joedayz.modelo.Categoria;
import com.joedayz.modelo.Producto;
import com.joedayz.repositorio.CategoriaRepositorio;
import com.joedayz.service.RegistroProductoService;
import com.joedayz.util.FacesUtil;

@Named
@ViewScoped
public class RegistroProductoBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private CategoriaRepositorio categoriaRepositorio;
	@Inject
	private RegistroProductoService productoService;
	
	private Producto producto;
	private List<Categoria> categoriasIniciales;
	private Categoria categoriaPadre;
	private List<Categoria> subCategorias;
	
	
	public RegistroProductoBean(){
		producto = new Producto();
	}
	
	public void inicializar(){
		if(!FacesUtil.isPostback()){
			categoriasIniciales = categoriaRepositorio.listarCategorias();
			
			if(this.categoriaPadre != null){
				cargarSubcategorias();
			}
			
		}
	}
	
	public Producto getProducto() {
		return producto;
	}

	public void cargarSubcategorias(){
		subCategorias = categoriaRepositorio.listarSubCategorias(categoriaPadre);
	}
	
	public void registrarProducto(){
		this.producto = productoService.registrarProducto(this.producto);
		limpiarFormulario();
		FacesUtil.adicionarMensajeInfo("El producto se registro correctamente");
	}

	private void limpiarFormulario(){
		producto = new Producto();
		categoriaPadre = null;
		subCategorias = null; 
	}
	
	public List<Categoria> getCategoriasIniciales() {
		return categoriasIniciales;
	}

	public Categoria getCategoriaPadre() {
		return categoriaPadre;
	}

	public void setCategoriaPadre(Categoria categoriaPadre) {
		this.categoriaPadre = categoriaPadre;
	}

	public List<Categoria> getSubCategorias() {
		return subCategorias;
	}

	public void setSubCategorias(List<Categoria> subCategorias) {
		this.subCategorias = subCategorias;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
		this.categoriaPadre = this.producto.getCategoria().getCategoriaPadre(); 
		
	}
	
	public boolean isEditando(){
		return this.producto.getIdeProducto() !=null;
	}
	
}
