package com.joedayz.modelo;

public enum EstadoPedido {
	EMITIDO("Emitido"), PRESUPUESTADO("Presupuestado"), CANCELADO("Cancelado");

	private String descripcion;

	EstadoPedido(String descripcion){
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	
}
