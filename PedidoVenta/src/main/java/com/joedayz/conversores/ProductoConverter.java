package com.joedayz.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.joedayz.modelo.Categoria;
import com.joedayz.modelo.Producto;
import com.joedayz.repositorio.CategoriaRepositorio;
import com.joedayz.repositorio.ProductoRepositorio;
import com.joedayz.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Producto.class)
public class ProductoConverter implements Converter{

	private ProductoRepositorio productoRepositorio;
	
	public ProductoConverter(){
		productoRepositorio = CDIServiceLocator.getBean(ProductoRepositorio.class);
	}
	
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		Producto retorno = null;
		
		if(value!=null){
			Long id = new Long(value);
			retorno = productoRepositorio.obtenerProducto(id); 
		}
		return retorno;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {

		if(value!=null){
			Producto producto = (Producto) value;
			return producto.getIdeProducto() == null ? null :  producto.getIdeProducto().toString();
		}
		
		return "";
	}

}
