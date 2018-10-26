package com.joedayz.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FechaValor implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Date fecha;
	private BigDecimal valor;
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	

}
