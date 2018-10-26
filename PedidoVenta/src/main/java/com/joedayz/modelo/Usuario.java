package com.joedayz.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="pvm_usuario")
public class Usuario  implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long ideUsuario;
	private String nombreUsuario;
	private String email;
	private String password;
	private List<Grupo> grupos = new ArrayList<Grupo>();
	
	@Id
	@GeneratedValue
	@Column(name="ide_usuario", nullable=false, length=10)
	public Long getIdeUsuario() {
		return ideUsuario;
	}
	public void setIdeUsuario(Long ideUsuario) {
		this.ideUsuario = ideUsuario;
	}
	@Column(name="nombre_usuario", nullable=false, unique=true,  length=50)
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	@Column(name="email", nullable=false, unique=true,  length=50)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="password", nullable=false,  length=50)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "pvr_usuario_grupo", joinColumns = @JoinColumn(name="ide_usuario"),
			inverseJoinColumns = @JoinColumn(name = "ide_grupo"))
	public List<Grupo> getGrupos() {
		return grupos;
	}
	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((ideUsuario == null) ? 0 : ideUsuario.hashCode());
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
		Usuario other = (Usuario) obj;
		if (ideUsuario == null) {
			if (other.ideUsuario != null)
				return false;
		} else if (!ideUsuario.equals(other.ideUsuario))
			return false;
		return true;
	}

	
}
