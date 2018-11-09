/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.web.view.bean.compra;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.spring.base.dominio.Categoria;
import pe.edu.cibertec.spring.base.dominio.Compra;
import pe.edu.cibertec.spring.base.dominio.DetalleCompra;
import pe.edu.cibertec.spring.base.dominio.Producto;
import pe.edu.cibertec.spring.base.dominio.Proveedor;
import pe.edu.cibertec.spring.base.service.CompraServicio;
import pe.edu.cibertec.spring.base.service.ProductoServicio;
import pe.edu.cibertec.spring.base.service.ProveedorServicio;
import pe.edu.cibertec.web.view.configuracion.GenericController;

/**
 *
 * @author julio
 */
@Component
@Scope("view")
public class CompraBean extends GenericController implements Serializable {

    @Autowired
    private CompraServicio compraServicio;

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private ProveedorServicio proveedorServicio;

    private Producto producto;
    private Compra compra;
    private List<Producto> listaProducto;
    private Proveedor proveedor;
    private DetalleCompra detalleCompra;
    private DetalleCompra detalleCompraSeleccionado;
    private List<DetalleCompra> listaDetalleCompra;
    private String ruc;
    private String razonSocial;
    private BigDecimal total;
    private BigDecimal subTotal;
    private BigDecimal igv;
    private String mensaje;
    private boolean mostrar;

    @PostConstruct
    public void init() {
        inicializar();

    }

    public void guardarCompra() {
        compra.setProveedor(proveedor);
        compraServicio.realizarCompra(listaDetalleCompra, compra);
        mensaje = "Se guardo con éxito";
        mostrar = Boolean.TRUE;

    }

    public void buscarProveedor() {
        if (ruc != null) {
            if (ruc.length() >= 11) {
                Proveedor prov = proveedorServicio.getProveedorByRuc(ruc);
                if (prov != null) {

                    proveedor = prov;
                } else {
                    proveedor = new Proveedor();
                    proveedor.setNombre("Ningún Resultado");
                }
            }

        }

    }

    public void add() {
        detalleCompra.setCantidad(0);
        detalleCompra.setProducto(producto);
        detalleCompra.setPrecio(0.0);
        listaDetalleCompra.add(0, detalleCompra);
        detalleCompra = new DetalleCompra();
        producto = new Producto();
        detalleCompraSeleccionado = new DetalleCompra();

    }

    public void calcularTotales() {
        for (DetalleCompra detalle : listaDetalleCompra) {
            subTotal = subTotal.add(new BigDecimal(detalle.getPrecio() * detalle.getCantidad()));
            total = total.add(subTotal);
        }
    }

    public List<Producto> completeProducto(String query) {
        List<Producto> listaProducto = productoServicio.obtenerTodos();
        List<Producto> filteredProductos = new ArrayList<Producto>();

        for (int i = 0; i < listaProducto.size(); i++) {
            Producto skin = listaProducto.get(i);
            if (skin.getNombre().toLowerCase().contains(query)) {
                filteredProductos.add(skin);
            }
        }

        return filteredProductos;
    }

    public void quitarDetalle() {
        listaDetalleCompra.remove(detalleCompraSeleccionado);
    }

    private void inicializar() {
        producto = new Producto();
        compra = new Compra();
        listaProducto = new ArrayList<>();
        listaDetalleCompra = new ArrayList<>();
        detalleCompra = new DetalleCompra();
        proveedor = new Proveedor();
        mensaje = "";
        mostrar = Boolean.FALSE;
//        ruc = "";
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public List<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public DetalleCompra getDetalleCompra() {
        return detalleCompra;
    }

    public void setDetalleCompra(DetalleCompra detalleCompra) {
        this.detalleCompra = detalleCompra;
    }

    public List<DetalleCompra> getListaDetalleCompra() {
        return listaDetalleCompra;
    }

    public void setListaDetalleCompra(List<DetalleCompra> listaDetalleCompra) {
        this.listaDetalleCompra = listaDetalleCompra;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public DetalleCompra getDetalleCompraSeleccionado() {
        return detalleCompraSeleccionado;
    }

    public void setDetalleCompraSeleccionado(DetalleCompra detalleCompraSeleccionado) {
        this.detalleCompraSeleccionado = detalleCompraSeleccionado;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getIgv() {
        return igv;
    }

    public void setIgv(BigDecimal igv) {
        this.igv = igv;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isMostrar() {
        return mostrar;
    }

    public void setMostrar(boolean mostrar) {
        this.mostrar = mostrar;
    }

}
