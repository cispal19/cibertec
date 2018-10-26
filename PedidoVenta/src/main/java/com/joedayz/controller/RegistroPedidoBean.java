package com.joedayz.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import com.joedayz.modelo.Cliente;
import com.joedayz.modelo.DireccionEntrega;
import com.joedayz.modelo.FormaPago;
import com.joedayz.modelo.ItemProducto;
import com.joedayz.modelo.Pedido;
import com.joedayz.modelo.Producto;
import com.joedayz.modelo.Usuario;
import com.joedayz.repositorio.ClienteRepositorio;
import com.joedayz.repositorio.ProductoRepositorio;
import com.joedayz.repositorio.UsuarioRepositorio;
import com.joedayz.service.NegocioExcepciones;
import com.joedayz.service.RegistroPedidoService;
import com.joedayz.util.FacesUtil;
import com.joedayz.util.validation.EdicionPedido;
import com.joedayz.util.validation.FormatSKU;

@Named
@ViewScoped
public class RegistroPedidoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject private UsuarioRepositorio usuarioRepositorio;
	@Inject private ClienteRepositorio clienteRepositorio;
	@Inject private RegistroPedidoService pedidoService;
	@Inject private ProductoRepositorio productoRepositorio;
	
	@Produces @EdicionPedido
	private Pedido pedido;
	
	private List<Usuario> vendedores;
	
	public List<Usuario> getVendedores() {
		return vendedores;
	}

	private Producto productoEditable;
	private String sku;
	
	@FormatSKU
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public void inicializar(){
		if(!FacesUtil.isPostback()){
			this.vendedores = usuarioRepositorio.listarVendedores();
			this.pedido.adicionarProductoInicial();
			this.recalcularPedido();
		}
	}
	
	public List<Cliente> completarCliente(String nombreCliente){
		return clienteRepositorio.buscarClienteporNombre(nombreCliente);
	}
	
	public List<Producto> completarProducto(String nombreProducto){
		return this.productoRepositorio.obtenerProductoporNombre(nombreProducto);
	}
	
	public void cargarProductoEditables(){
		ItemProducto item = this.pedido.getItens().get(0);
		
		if(this.productoEditable != null){
			if(this.existeItemProducto(this.productoEditable)){
				FacesUtil.adicionarMensajeError("El producto ya esta agregado a la lista");
			}else{
				item.setProducto(this.productoEditable);
				item.setValorUnitario(this.productoEditable.getValorUnitario());
				
				this.pedido.adicionarProductoInicial();
				this.productoEditable = null;
				this.sku=null;
				this.pedido.recalcularValorTotal();
			}
		}
	}
	
	private boolean existeItemProducto(Producto producto){
		boolean existe = false;
		
		for(ItemProducto item : this.getPedido().getItens()){
			if(producto.equals(item.getProducto())){
				existe=true;
				break;
			}
		}
		return existe;
	}
	
	public void cargarProductosporSku(){
		if(StringUtils.isNotBlank(this.sku)){
			this.productoEditable = this.productoRepositorio.obtenerProductoporSKU(this.sku);
			this.cargarProductoEditables();
		}
	}
	
	public void actualizarCantidad(ItemProducto item, int linea){
		if(item.getCantidad() < 1){
			if(linea == 0){
				item.setCantidad(1);
			}else{
				this.getPedido().getItens().remove(linea);
			}
		}
		this.pedido.recalcularValorTotal();
	}
	
	
	public FormaPago[] getFormasdePago(){
		return FormaPago.values();
	}
	
	public RegistroPedidoBean(){
		limpiar();
	}
	
	private void limpiar(){
		pedido = new Pedido();
		pedido.setDireccionEntrega(new DireccionEntrega());
	}
	
	public void registrarPedido(){
		this.pedido.removerProductoInicial();
		try{
			this.pedido = this.pedidoService.registrarPedido(this.pedido);
//			limpiar();
			FacesUtil.adicionarMensajeInfo("El registro del pedido fue satisfactorio.");
		}finally{
			this.pedido.adicionarProductoInicial();
		}
	}

	public void pedidoAlterado(@Observes PedidoAlteradoEvent evento){
		this.pedido = evento.getPedido();
	}
	
	public Pedido getPedido() {
		return pedido;
	}
	
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public boolean isEditando(){
		return this.pedido.getIdPedido() != null;
	}
	
	public void recalcularPedido(){
		if(this.pedido !=null){
			this.pedido.recalcularValorTotal();
		}
	}

	public Producto getProductoEditable() {
		return productoEditable;
	}

	public void setProductoEditable(Producto productoEditable) {
		this.productoEditable = productoEditable;
	}
	
}
