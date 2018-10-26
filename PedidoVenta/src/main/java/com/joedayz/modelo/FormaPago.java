package com.joedayz.modelo;

public enum FormaPago {
	DINERO("Dinero"), CARTA_CREDITO("Carta de Credito"), 
	CARTA_DEBIDO("Carta de Debito"), CHEQUE("Cheque"), 
	DEPOSITO_BANCARIO("Deposito Bancario");
	
	private String descripcion;
	
	public String getDescripcion() {
		return descripcion;
	}

	FormaPago(String descripcion) {
		this.descripcion = descripcion;
	}

}
