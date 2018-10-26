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
import javax.persistence.Transient;

@Entity
@Table(name = "pvm_item_producto")
public class ItemProducto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long idItemProducto;
	private Integer cantidad = 1;
	private BigDecimal valorUnitario = BigDecimal.ZERO;
	private Producto producto;
	private Pedido pedido;
	
	@Id
	@GeneratedValue
	@Column(name="ide_item_producto", nullable=false, length=10)
	public Long getIdItemProducto() {
		return idItemProducto;
	}
	public void setIdItemProducto(Long idItemProducto) {
		this.idItemProducto = idItemProducto;
	}
	
	@Column(name="cantidad", nullable = false, length = 3)
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	@Column(name = "valor_unitario", nullable = false, precision = 10, scale = 2)
	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	@ManyToOne
	@JoinColumn(name = "ide_produto", nullable = false)
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	@ManyToOne
	@JoinColumn(name = "ide_pedido", nullable = false)
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idItemProducto == null) ? 0 : idItemProducto.hashCode());
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
		ItemProducto other = (ItemProducto) obj;
		if (idItemProducto == null) {
			if (other.idItemProducto != null)
				return false;
		} else if (!idItemProducto.equals(other.idItemProducto))
			return false;
		return true;
	}
	
	@Transient
	public BigDecimal getValorTotal() {
		return this.getValorUnitario().multiply(new BigDecimal(this.getCantidad())); 
	}
	
	@Transient
	public boolean isProductoAsociado(){
		return this.getProducto() != null && this.getProducto().getIdeProducto()!=null;
	}
	
	@Transient
	public boolean isStockSuficiente(){
		return this.getPedido().isEmitido() || this.getProducto().getIdeProducto()==null 
				|| this.getProducto().getStock() >= this.getCantidad();
	}
	
	@Transient
	public boolean isStockInsuficiente(){
		return !this.isStockSuficiente();
	}
}
