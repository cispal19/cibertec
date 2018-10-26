package com.joedayz.modelo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.joedayz.service.NegocioExcepciones;
import com.joedayz.util.validation.FormatSKU;

@Entity
@Table(name="pvm_produto")
public class Producto implements Serializable  {

	private static final long serialVersionUID = 1L;

	private Long ideProducto;
	private String nombreProducto;
	private String sku;
	private BigDecimal valorUnitario;
	private Integer stock;
	private Categoria categoria;
	
	@Id
	@GeneratedValue
	@Column(name="ide_producto", nullable=false, length=10)
	public Long getIdeProducto() {
		return ideProducto;
	}
	public void setIdeProducto(Long ideProducto) {
		this.ideProducto = ideProducto;
	}
	
	@NotBlank @Size(max = 60)
	@Column(name="nombre_producto", nullable=false, length=60)
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	@NotBlank @FormatSKU
	@Column(name="sku", unique=true, nullable=false, length=20)
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	@NotNull
	@Column(name="valor_unitario", nullable = false, precision = 10, scale = 2)
	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	@NotNull(message="es obligatorio") @Min(0) @Max(value = 9999, message = "El valor ingresado es muy alto")
	@Column(name="stock", nullable = false, length = 5)
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	@NotNull
	@ManyToOne
	@JoinColumn(name = "ide_categoria", nullable = false)
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((ideProducto == null) ? 0 : ideProducto.hashCode());
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
		Producto other = (Producto) obj;
		if (ideProducto == null) {
			if (other.ideProducto != null)
				return false;
		} else if (!ideProducto.equals(other.ideProducto))
			return false;
		return true;
	}
	
	public void nuevaCantidad(Integer cantidad) {
		int nuevoStock = this.getStock() - cantidad;
		
		if(nuevoStock < 0){
			throw new NegocioExcepciones("No hay disponibilidad de stock para "+
								cantidad + " items del producto "+this.getSku());
		}
		this.setStock(nuevoStock);
	}
	
	public void devolverStock(Integer cantidad) {
		this.setStock(this.getStock()+cantidad);
	}

	
}
