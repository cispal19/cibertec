package com.joedayz.controller;

import com.joedayz.modelo.Pedido;

public class PedidoAlteradoEvent {

	private Pedido pedido;
	
	public PedidoAlteradoEvent(Pedido pedido){
		this.pedido = pedido;
	}

	public Pedido getPedido() {
		return pedido;
	}
	
}
