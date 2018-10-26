package com.joedayz.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.joedayz.modelo.Cliente;
import com.joedayz.repositorio.ClienteRepositorio;
import com.joedayz.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Cliente.class)
public class ClienteConverter implements Converter{

	private ClienteRepositorio clienteRepositorio;

	public ClienteConverter() {
		this.clienteRepositorio = (ClienteRepositorio) CDIServiceLocator.getBean(ClienteRepositorio.class);
	}

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Cliente retorno = null;

		if (value != null) {
			retorno = this.clienteRepositorio.buscarClienteporId(new Long(value));
		}

		return retorno;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Cliente) value).getIdeCliente().toString();
		}
		return "";
	}
	
}
