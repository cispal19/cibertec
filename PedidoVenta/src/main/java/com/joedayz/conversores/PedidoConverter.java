package com.joedayz.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.joedayz.modelo.Categoria;
import com.joedayz.modelo.Pedido;
import com.joedayz.modelo.Producto;
import com.joedayz.repositorio.CategoriaRepositorio;
import com.joedayz.repositorio.PedidoRepositorio;
import com.joedayz.repositorio.ProductoRepositorio;
import com.joedayz.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Pedido.class)
public class PedidoConverter implements Converter{

	private PedidoRepositorio pedidoRepositorio;
	
	public PedidoConverter(){
		pedidoRepositorio = CDIServiceLocator.getBean(PedidoRepositorio.class);
	}
	
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		Pedido retorno = null;
		
		if(value!=null){
			Long id = new Long(value);
			retorno = pedidoRepositorio.obtenerPedido(id); 
		}
		return retorno;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {

		if(value!=null){
			Pedido pedido = (Pedido) value;
			return pedido.getIdPedido() == null ? null : pedido.getIdPedido().toString();
		}
		
		return "";
	}

}
