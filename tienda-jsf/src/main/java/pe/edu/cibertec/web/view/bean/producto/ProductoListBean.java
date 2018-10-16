/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.web.view.bean.producto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.spring.base.dominio.Producto;
import pe.edu.cibertec.spring.base.service.ProductoServicio;
import pe.edu.cibertec.web.view.configuracion.GenericController;

/**
 *
 * @author JCISNEROSP
 */
@Component
@Scope("view")
public class ProductoListBean extends GenericController implements Serializable{

    @Autowired
    private ProductoServicio productoServicio;

    private Producto producto;
    private List<Producto> listaProducto;

    @PostConstruct
    public void init() {
        inicializar();
        listaProducto = productoServicio.obtenerTodos();

    }

    private void inicializar() {
        producto = new Producto();
        listaProducto = new ArrayList<>();
    }

    public String editar() {
        setParamInFlashContext(PRODUCTO, producto);
        return "/pages/producto/productoForm?faces-redirect=true";

    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }
    
    

}
