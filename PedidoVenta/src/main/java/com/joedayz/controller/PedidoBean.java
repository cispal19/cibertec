package com.joedayz.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.joedayz.modelo.EstadoPedido;
import com.joedayz.modelo.Pedido;
import com.joedayz.repositorio.PedidoRepositorio;
import com.joedayz.repositorio.filtros.PedidoFiltros;
import com.joedayz.service.NegocioExcepciones;

@Named
@ViewScoped
public class PedidoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject PedidoRepositorio pedidoRepositorio; 
	
	private List<Pedido> pedidosFiltrados;
	private PedidoFiltros filtros;
	
	public List<Pedido> getPedidosFiltrados() {
		return pedidosFiltrados;
	}
	
	public PedidoBean(){
		pedidosFiltrados = new ArrayList<Pedido>();
		filtros = new PedidoFiltros();	
	}
	
	public void buscarPedido(){
		pedidosFiltrados = pedidoRepositorio.listarPedidosFiltrados(filtros);
	}
	
	public EstadoPedido[] getEstadosPedido(){
		return EstadoPedido.values();
	}

	public PedidoFiltros getFiltros() {
		return filtros;
	}
	
	
}
