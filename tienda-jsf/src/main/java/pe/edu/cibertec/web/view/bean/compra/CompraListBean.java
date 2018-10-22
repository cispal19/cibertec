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
import pe.edu.cibertec.spring.base.dominio.Compra;
import pe.edu.cibertec.spring.base.service.CompraServicio;
import pe.edu.cibertec.web.view.configuracion.GenericController;

/**
 *
 * @author JCISNEROSP
 */
@Component
@Scope("view")
public class CompraListBean extends GenericController implements Serializable {

    @Autowired
    private CompraServicio compraServicio;

    private List<Compra> listaCompra;
    private Compra compra;
    private Compra compraSeleccionado;

    @PostConstruct
    public void init() {
        inicializar();
        listaCompra = compraServicio.obtenerTodos();

    }

    public void inicializar() {
        listaCompra = new ArrayList<>();
        compra = new Compra();
        compraSeleccionado = new Compra();

    }

    public String nuevo() {
        return "/pages/compra/compraForm?faces-redirect=true";
    }

    public String editar() {
        setParamInFlashContext(COMPRA, compraSeleccionado);
        return "/pages/compra/compraForm?faces-redirect=true";

    }
    
    
    public void buscar(){
    listaCompra=compraServicio.listarCompra(compra);
    
    }

    public List<Compra> getListaCompra() {
        return listaCompra;
    }

    public void setListaCompra(List<Compra> listaCompra) {
        this.listaCompra = listaCompra;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Compra getCompraSeleccionado() {
        return compraSeleccionado;
    }

    public void setCompraSeleccionado(Compra compraSeleccionado) {
        this.compraSeleccionado = compraSeleccionado;
    }
    
    
    

}
