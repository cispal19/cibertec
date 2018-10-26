package com.joedayz.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.joedayz.modelo.Cliente;
import com.joedayz.modelo.Usuario;
import com.joedayz.repositorio.ClienteRepositorio;
import com.joedayz.repositorio.UsuarioRepositorio;
import com.joedayz.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Usuario.class)
public class UsuarioConverter implements Converter{

	private UsuarioRepositorio usuarioRepositorio;

	public UsuarioConverter() {
		this.usuarioRepositorio = (UsuarioRepositorio) CDIServiceLocator.getBean(UsuarioRepositorio.class);
	}

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Usuario retorno = null;

		if (value != null) {
			retorno = this.usuarioRepositorio.buscarUsuarioporId(new Long(value));
		}

		return retorno;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Usuario) value).getIdeUsuario().toString();
		}
		return "";
	}
	
}
