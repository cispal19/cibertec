package com.joedayz.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="pvm_pedido")
public class Pedido implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private Long idPedido;
	private Date fechaPedido;
	private String observacion;
	private Date fechaEntrega;
	private BigDecimal valorTransporte = BigDecimal.ZERO;
	private BigDecimal valorDescuento = BigDecimal.ZERO;
	private BigDecimal valorTotal = BigDecimal.ZERO;
	private EstadoPedido estadoPedido = EstadoPedido.PRESUPUESTADO;
	private FormaPago formaPago;
	private Usuario vendedor;
	private Cliente cliente;
	private DireccionEntrega direccionEntrega;
	private List<ItemProducto> itens = new ArrayList<ItemProducto>();
	
	@Id
	@GeneratedValue
	@Column(name="ide_pedido", nullable=false, length=10)
	public Long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_pedido", nullable = false)
	public Date getFechaPedido() {
		return fechaPedido;
	}
	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	
	@Column(name="observacion", columnDefinition = "text")
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_entrega", nullable = false)
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	
	@NotNull
	@Column(name = "valor_transporte", nullable = false, precision = 10, scale = 2)
	public BigDecimal getValorTransporte() {
		return valorTransporte;
	}
	public void setValorTransporte(BigDecimal valorTransporte) {
		this.valorTransporte = valorTransporte;
	}
	
	@NotNull
	@Column(name = "valor_descuento", nullable = false, precision = 10, scale = 2)
	public BigDecimal getValorDescuento() {
		return valorDescuento;
	}
	public void setValorDescuento(BigDecimal valorDescuento) {
		this.valorDescuento = valorDescuento;
	}
	
	@NotNull
	@Column(name = "valor_total", nullable = false, precision = 10, scale = 2)
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="estado_pedido",nullable = false, length = 20)
	public EstadoPedido getEstadoPedido() {
		return estadoPedido;
	}
	public void setEstadoPedido(EstadoPedido estadoPedido) {
		this.estadoPedido = estadoPedido;
	}
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "forma_pago", nullable = false, length = 20)
	public FormaPago getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(FormaPago formaPago) {
		this.formaPago = formaPago;
	}
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "ide_vendedor", nullable = false)
	public Usuario getVendedor() {
		return vendedor;
	}
	public void setVendedor(Usuario vendedor) {
		this.vendedor = vendedor;
	}
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "ide_cliente", nullable = false)
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Embedded
	public DireccionEntrega getDireccionEntrega() {
		return direccionEntrega;
	}
	public void setDireccionEntrega(DireccionEntrega direccionEntrega) {
		this.direccionEntrega = direccionEntrega;
	}
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	public List<ItemProducto> getItens() {
		return itens;
	}
	public void setItens(List<ItemProducto> itens) {
		this.itens = itens;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idPedido == null) ? 0 : idPedido.hashCode());
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
		Pedido other = (Pedido) obj;
		if (idPedido == null) {
			if (other.idPedido != null)
				return false;
		} else if (!idPedido.equals(other.idPedido))
			return false;
		return true;
	}
	
	@Transient
	public BigDecimal getValorSubtotal(){
		return this.getValorTotal().subtract(this.getValorTransporte()).add(this.getValorDescuento());
	}
	
	public void recalcularValorTotal() {
		BigDecimal total = BigDecimal.ZERO;
		total = total.add(this.getValorTransporte()).subtract(this.getValorDescuento());

		for(ItemProducto item : this.getItens()){
			if(item.getProducto() !=null && item.getProducto().getIdeProducto() !=null){
				total = total.add(item.getValorTotal());
			}
			
		}
		
		this.setValorTotal(total);
	}
	public void adicionarProductoInicial() {
		if(this.isPresupuestado()){
			Producto producto = new Producto();
			producto.setStock(1);
			
			ItemProducto item = new ItemProducto();
			item.setProducto(producto);
			item.setPedido(this);
			
			this.getItens().add(0, item);
		}
	}
	
	@Transient
	private boolean isPresupuestado(){
		return EstadoPedido.PRESUPUESTADO.equals(this.getEstadoPedido());
	}
	
	public void removerProductoInicial() {
		ItemProducto primerItem = this.getItens().get(0);
		if(primerItem != null && primerItem.getProducto().getIdeProducto() == null){
			this.getItens().remove(0);
		}
	}
	@Transient
	public boolean isValorTotalNegativo() {
		return this.getValorTotal().compareTo(BigDecimal.ZERO) < 0;
	}
	
	@Transient
	public boolean isEmitido() {
		return EstadoPedido.EMITIDO.equals(this.getEstadoPedido());
	}
	
	@Transient
	public boolean isNoEmitible() {
		return !this.isEmitible();
	}
	
	@Transient
	public boolean isEmitible() {
		return this.getIdPedido()!= null && this.isPresupuestado();
	}
	
	@Transient
	public boolean isNoCancelable() {
		return !this.isCancelable();
	}
	
	@Transient
	public boolean isCancelable() {
		return this.getIdPedido()!= null && !this.isCancelado();
	}
	
	@Transient
	public boolean isCancelado() {
		return EstadoPedido.CANCELADO.equals(this.getEstadoPedido());
	}
	
	@Transient
	public boolean isNoAlterable() {
		return !this.isAlterable();
	}
	@Transient
	public boolean isAlterable() {
		return this.isPresupuestado();
	}
	
	@Transient
	public boolean isNoEnviableEmail(){
		return this.getIdPedido() == null || this.isCancelado();
	}
	
}
