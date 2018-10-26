package com.joedayz.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pvm_categoria")
public class Categoria implements Serializable  {

	private static final long serialVersionUID = 1L;

	private Long ideCategoria;
	private String descripcion;
	private Categoria categoriaPadre;
	private List<Categoria> subcategorias = new ArrayList<Categoria>();
	
	@Id
	@GeneratedValue
	@Column(name="ide_categoria", nullable=false, length=10)
	public Long getIdeCategoria() {
		return ideCategoria;
	}
	public void setIdeCategoria(Long ideCategoria) {
		this.ideCategoria = ideCategoria;
	}
	
	@Column(name="descripcion", nullable = false, length = 60)
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@ManyToOne
	@JoinColumn(name = "ide_categoria_padre")
	public Categoria getCategoriaPadre() {
		return categoriaPadre;
	}
	public void setCategoriaPadre(Categoria categoriaPadre) {
		this.categoriaPadre = categoriaPadre;
	}
	
	@OneToMany(mappedBy = "categoriaPadre", cascade = CascadeType.ALL)
	public List<Categoria> getSubcategorias() {
		return subcategorias;
	}
	public void setSubcategorias(List<Categoria> subcategorias) {
		this.subcategorias = subcategorias;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((ideCategoria == null) ? 0 : ideCategoria.hashCode());
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
		Categoria other = (Categoria) obj;
		if (ideCategoria == null) {
			if (other.ideCategoria != null)
				return false;
		} else if (!ideCategoria.equals(other.ideCategoria))
			return false;
		return true;
	}

	
}
