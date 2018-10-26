package com.joedayz.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.joedayz.modelo.Pedido;
import com.joedayz.service.EmisionPedidoService;
import com.joedayz.util.FacesUtil;
import com.joedayz.util.validation.EdicionPedido;

@Named
@RequestScoped
public class EmisionPedidoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject @EdicionPedido
	private Pedido pedido;
	
	@Inject
	private EmisionPedidoService emisionPedidoService; 
	
	@Inject
	private Event<PedidoAlteradoEvent> pedidoAlteradoEvent;
	
	public void emitirPedido(){
		this.pedido.removerProductoInicial();
		try{
			this.pedido = emisionPedidoService.emitir(this.pedido);
			this.pedidoAlteradoEvent.fire(new PedidoAlteradoEvent(this.pedido));
			FacesUtil.adicionarMensajeInfo("Pedido Emitido satisfactoriamente!.");
		}finally{
			this.pedido.adicionarProductoInicial();
		}
	}

}
