package com.joedayz.repositorio.filtros;

import java.io.Serializable;
import java.util.Date;

import com.joedayz.modelo.EstadoPedido;

public class PedidoFiltros implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long numeroInicial;
	private Long numeroFinal;
	private Date fechaInicial;
	private Date fechaFinal;
	private String nombreVendedor;
	private String nombreCliente;
	private EstadoPedido[] estadoPedidos;
	
	public Long getNumeroInicial() {
		return numeroInicial;
	}
	public void setNumeroInicial(Long numeroInicial) {
		this.numeroInicial = numeroInicial;
	}
	public Long getNumeroFinal() {
		return numeroFinal;
	}
	public void setNumeroFinal(Long numeroFinal) {
		this.numeroFinal = numeroFinal;
	}
	public Date getFechaInicial() {
		return fechaInicial;
	}
	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	public Date getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public String getNombreVendedor() {
		return nombreVendedor;
	}
	public void setNombreVendedor(String nombreVendedor) {
		this.nombreVendedor = nombreVendedor;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public EstadoPedido[] getEstadoPedidos() {
		return estadoPedidos;
	}
	public void setEstadoPedidos(EstadoPedido[] estadoPedidos) {
		this.estadoPedidos = estadoPedidos;
	}
	
	
}
