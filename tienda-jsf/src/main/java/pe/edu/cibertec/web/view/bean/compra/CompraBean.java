/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.web.view.bean.compra;

import java.io.Serializable;
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
    private List<DetalleCompra> listaDetalleCompra;

    @PostConstruct
    public void init() {
        inicializar();

    }

    public void guardarCompra() {
        for (int i = 1; i < 5; i++) {
            Producto pro = new Producto();
            pro.setId(i);
            pro.setNombre("nuevo");
            Categoria catego = new Categoria();
            catego.setId(1);
            pro.setCategoria(catego);
            detalleCompra.setProducto(pro);
            detalleCompra.setPrecio(20);
            detalleCompra.setCantidad(10);
            listaDetalleCompra.add(detalleCompra);

        }
        compraServicio.realizarCompra(listaDetalleCompra, compra);

    }

    private void inicializar() {
        producto = new Producto();
        compra = new Compra();
        listaProducto = new ArrayList<>();
        listaDetalleCompra = new ArrayList<>();
        detalleCompra = new DetalleCompra();
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

}
