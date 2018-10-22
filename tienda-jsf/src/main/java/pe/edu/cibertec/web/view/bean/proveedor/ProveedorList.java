/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.web.view.bean.proveedor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.spring.base.dominio.Proveedor;
import pe.edu.cibertec.spring.base.service.ProveedorServicio;
import pe.edu.cibertec.web.view.configuracion.GenericController;

/**
 *
 * @author julio
 */
@Component
@Scope("view")
public class ProveedorList extends GenericController implements Serializable {

    @Autowired
    private ProveedorServicio proveedorServicio;

    private List<Proveedor> listaProveedor;
    private Proveedor proveedor;

    @PostConstruct
    public void init() {

        listaProveedor = new ArrayList<>();
        listaProveedor = proveedorServicio.obtenerTodos();

    }

    ;
    
    public String nuevo() {
        return "/pages/proveedor/proveedorForm?faces-redirect=true";
    }

    public String editar() { 
        setParamInFlashContext(PROVEEDOR, proveedor);
         return "/pages/proveedor/proveedorForm?faces-redirect=true";
    }

    public List<Proveedor> getListaProveedor() {
        return listaProveedor;
    }

    public void setListaProveedor(List<Proveedor> listaProveedor) {
        this.listaProveedor = listaProveedor;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
    

}
