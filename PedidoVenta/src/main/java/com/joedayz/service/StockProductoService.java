package com.joedayz.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.joedayz.modelo.ItemProducto;
import com.joedayz.modelo.Pedido;
import com.joedayz.repositorio.PedidoRepositorio;
import com.joedayz.util.jpa.Transaccion;

public class StockProductoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PedidoRepositorio pedidoRepositorio;
	
	@Transaccion
	public void actualizarStock(Pedido pedido) {
		pedido = this.pedidoRepositorio.obtenerPedido(pedido.getIdPedido());
		for(ItemProducto item : pedido.getItens()){
			item.getProducto().nuevaCantidad(item.getCantidad());
		}
	}
	
	public void retornarItemsStock(Pedido pedido) {
		pedido = this.pedidoRepositorio.obtenerPedido(pedido.getIdPedido());
		for(ItemProducto item : pedido.getItens()){
			item.getProducto().devolverStock(item.getCantidad());
		}
	}

}
