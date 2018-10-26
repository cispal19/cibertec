package com.joedayz.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pvm_cliente")
public class Cliente {

	private Long ideCliente;
	private String nombreCliente;
	private String email;
	private String numeroDocumento;
	private TipoPersona tipo;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipo_persona", nullable=false, length = 50)
	public TipoPersona getTipo() {
		return tipo;
	}
	public void setTipo(TipoPersona tipo) {
		this.tipo = tipo;
	}
	@Id
	@GeneratedValue
	@Column(name="ide_cliente", nullable = false, length= 10)
	public Long getIdeCliente() {
		return ideCliente;
	}
	public void setIdeCliente(Long ideCliente) {
		this.ideCliente = ideCliente;
	}
	@Column(name="nombre_cliente", nullable=false, length = 255)
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	
	@Column(name="email", unique=true, nullable=false, length = 100)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="numero_documento", unique=true, nullable=false, length = 11)
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((ideCliente == null) ? 0 : ideCliente.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (ideCliente == null) {
			if (other.ideCliente != null)
				return false;
		} else if (!ideCliente.equals(other.ideCliente))
			return false;
		return true;
	}
	
	
	
}
