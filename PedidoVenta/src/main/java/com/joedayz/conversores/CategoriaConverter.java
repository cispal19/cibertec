package com.joedayz.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.joedayz.modelo.Categoria;
import com.joedayz.repositorio.CategoriaRepositorio;
import com.joedayz.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Categoria.class)
public class CategoriaConverter implements Converter{

//	@Inject
	private CategoriaRepositorio categoriaRepositorio;
	
	public CategoriaConverter(){
		categoriaRepositorio = CDIServiceLocator.getBean(CategoriaRepositorio.class);
	}
	
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		Categoria retorno = null;
		
		if(value!=null){
			Long id = new Long(value);
			retorno = categoriaRepositorio.obtenerCategoria(id); 
		}
		return retorno;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {

		if(value!=null){
			return ((Categoria)value).getIdeCategoria().toString();
		}
		
		return "";
	}

}
