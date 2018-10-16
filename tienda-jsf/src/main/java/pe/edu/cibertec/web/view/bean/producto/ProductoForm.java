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
import javax.swing.text.StyleConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.spring.base.dominio.Categoria;
import pe.edu.cibertec.spring.base.dominio.Producto;
import pe.edu.cibertec.spring.base.service.CategoriaServicio;
import pe.edu.cibertec.spring.base.service.ProductoServicio;
import pe.edu.cibertec.web.view.configuracion.GenericController;

/**
 *
 * @author JCISNEROSP
 */
@Component
@Scope("view")
public class ProductoForm extends GenericController implements Serializable {

    private Producto producto;
    private boolean mostrar;
    private List<Categoria> listaCategoria;
    private String mensaje;

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private CategoriaServicio categoriaServicio;

    @PostConstruct
    public void init() {
        listaCategoria = categoriaServicio.obtenerTodos();
        Producto productoObtenido = (Producto) getParamInFlashContext(PRODUCTO);
        if (productoObtenido != null) {
            producto = productoObtenido;

        } else {
            inicializar();
            listaCategoria = categoriaServicio.obtenerTodos();
        }

    }

    public void inicializar() {
        producto = new Producto();
        listaCategoria = new ArrayList<>();
        mensaje = "";
        mostrar = Boolean.FALSE;

    }

    public void guardarProducto() {
        System.out.println(producto);
        if (producto.getId() == 0) {
            productoServicio.guardar(producto);
        } else {
            productoServicio.actualizar(producto);
        }

//        productoServicio.guardar(producto);
        mensaje = "Se guardo con éxito";
        mostrar = Boolean.TRUE;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Categoria> getListaCategoria() {
        return listaCategoria;
    }

    public void setListaCategoria(List<Categoria> listaCategoria) {
        this.listaCategoria = listaCategoria;
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
