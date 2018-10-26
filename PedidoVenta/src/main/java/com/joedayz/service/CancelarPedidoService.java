package com.joedayz.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.joedayz.modelo.EstadoPedido;
import com.joedayz.modelo.Pedido;
import com.joedayz.repositorio.PedidoRepositorio;
import com.joedayz.util.jpa.Transaccion;

public class CancelarPedidoService implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject private PedidoRepositorio pedidoRepositorio;
	
	@Inject private StockProductoService stockProductoService;
	
	@Transaccion
	public Pedido cancelar(Pedido pedido) {
		pedido = this.pedidoRepositorio.obtenerPedido(pedido.getIdPedido()); 
		if(pedido.isNoCancelable()){
			throw new NegocioExcepciones("El pedido no puede ser cancelado, tiene estado"+
								pedido.getEstadoPedido().getDescripcion());
		}
		
		if(pedido.isEmitido()){
			this.stockProductoService.retornarItemsStock(pedido);
		}
		pedido.setEstadoPedido(EstadoPedido.CANCELADO);
		pedido = this.pedidoRepositorio.adicionarPedido(pedido);
		return pedido;
	}

	
	
}
