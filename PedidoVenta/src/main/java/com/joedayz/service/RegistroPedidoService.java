package com.joedayz.service;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import com.joedayz.modelo.EstadoPedido;
import com.joedayz.modelo.Pedido;
import com.joedayz.repositorio.PedidoRepositorio;
import com.joedayz.util.jpa.Transaccion;

public class RegistroPedidoService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject PedidoRepositorio pedidoRepositorio;

	@Transaccion
	public Pedido registrarPedido(Pedido pedido){
		
		if(pedido.getIdPedido()==null){
			pedido.setFechaPedido(new Date());
			pedido.setEstadoPedido(EstadoPedido.PRESUPUESTADO);
		}
		
		pedido.recalcularValorTotal();
		if(pedido.getItens().isEmpty()){
			throw new NegocioExcepciones("Para poder registrar debe de ingresar al menos 1 producto.");
		}
		
		if(pedido.isValorTotalNegativo()){
			throw new NegocioExcepciones("Valor Total del pedido no puede ser negativo.");
		}
		
		if(pedido.isNoAlterable()){
			throw new NegocioExcepciones("El pedido no puede ser alterado, esta en estado "+
							pedido.getEstadoPedido().getDescripcion());
		}
		
		pedido = pedidoRepositorio.adicionarPedido(pedido);
		return pedido;
	}
}
