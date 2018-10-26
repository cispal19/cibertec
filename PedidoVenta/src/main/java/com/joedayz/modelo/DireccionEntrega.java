package com.joedayz.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Embeddable
public class DireccionEntrega implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String ciudad;
	private String distrito;
	private String direccionEntrega;
	private String referencia;
	private String numeroContacto;
	
	@NotBlank @Size(max = 150)
	@Column(name = "ciudad", nullable = false, length = 150)
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	@NotBlank @Size(max = 100)
	@Column(name = "distrito", nullable = false, length = 100)
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	@NotBlank @Size(max = 150)
	@Column(name = "direccion_entrega", nullable = false, length = 150)
	public String getDireccionEntrega() {
		return direccionEntrega;
	}
	public void setDireccionEntrega(String direccionEntrega) {
		this.direccionEntrega = direccionEntrega;
	}
	
	@NotBlank @Size(max = 80)
	@Column(name = "referencia", nullable = false, length = 80)
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	@NotBlank @Size(max = 10)
	@Column(name = "numero_contacto", nullable = false, length = 10)
	public String getNumeroContacto() {
		return numeroContacto;
	}
	public void setNumeroContacto(String numeroContacto) {
		this.numeroContacto = numeroContacto;
	}
		
	
}
