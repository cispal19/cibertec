package com.joedayz.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import com.joedayz.modelo.Pedido;
import com.joedayz.service.CancelarPedidoService;
import com.joedayz.util.FacesUtil;
import com.joedayz.util.validation.EdicionPedido;

@Named
@RequestScoped
public class CancelarPedidoBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject private CancelarPedidoService cancelarPedidoService;
	
	@Inject private Event<PedidoAlteradoEvent> pedidoAlteradoEvent;
	
	@Inject @EdicionPedido private Pedido pedido;
	
	public void cancelarPedido(){
		this.pedido = this.cancelarPedidoService.cancelar(this.pedido);
		this.pedidoAlteradoEvent.fire(new PedidoAlteradoEvent(this.pedido));
		FacesUtil.adicionarMensajeInfo("El Pedido fue cancelado.");
	}
	
}
