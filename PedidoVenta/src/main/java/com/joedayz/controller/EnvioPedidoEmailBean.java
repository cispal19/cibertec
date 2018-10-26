package com.joedayz.controller;

import java.io.Serializable;
import java.util.Locale;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.velocity.tools.generic.NumberTool;

import com.joedayz.modelo.Pedido;
import com.joedayz.util.FacesUtil;
import com.joedayz.util.mail.Mailer;
import com.joedayz.util.validation.EdicionPedido;
import com.outjected.email.api.MailMessage;
import com.outjected.email.impl.templating.velocity.VelocityTemplate;

@Named
@RequestScoped
public class EnvioPedidoEmailBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject private Mailer mailer;
	
	@Inject @EdicionPedido
	private Pedido pedido;
	
	public void enviarPedido(){
		MailMessage mensaje = mailer.nuevoEmail();
		mensaje.to(this.pedido.getCliente().getEmail())
				.subject("Su pedido "+this.pedido.getIdPedido())
				.bodyHtml(new VelocityTemplate(getClass().getResourceAsStream("/emails/email.template")))
				.put("pedido", this.pedido)
				.put("numberTool", new NumberTool())
				.put("locale", new Locale("es", "PE"))
				.send();
		
		FacesUtil.adicionarMensajeInfo("Pedido enviado por email satisfactoriamente.");
	}
}
