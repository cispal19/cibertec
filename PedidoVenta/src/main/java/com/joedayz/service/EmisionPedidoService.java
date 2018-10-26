package com.joedayz.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.joedayz.modelo.EstadoPedido;
import com.joedayz.modelo.Pedido;
import com.joedayz.repositorio.PedidoRepositorio;
import com.joedayz.util.jpa.Transaccion;

public class EmisionPedidoService implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject	private RegistroPedidoService registroPedidoService;
	@Inject	private PedidoRepositorio pedidoRepositorio;
	@Inject private StockProductoService stockProductoService;
	
	@Transaccion
	public Pedido emitir(Pedido pedido) {
		pedido = this.registroPedidoService.registrarPedido(pedido);
		if(pedido.isNoEmitible()){
			throw new NegocioExcepciones("Pedido no puede ser emitido por estar en Estado "
							+ pedido.getEstadoPedido().getDescripcion());
		}
		this.stockProductoService.actualizarStock(pedido);
		pedido.setEstadoPedido(EstadoPedido.EMITIDO);
		pedido = this.pedidoRepositorio.adicionarPedido(pedido);
		return pedido;
	}

}
