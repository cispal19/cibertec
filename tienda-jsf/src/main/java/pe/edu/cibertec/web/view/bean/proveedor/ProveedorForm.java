/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.web.view.bean.proveedor;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.spring.base.dominio.Proveedor;
import pe.edu.cibertec.spring.base.service.ProveedorServicio;
import pe.edu.cibertec.web.view.configuracion.GenericController;

/**
 *
 * @author JCISNEROSP
 */
@Component
@Scope("view")
public class ProveedorForm extends GenericController implements Serializable {

    private Proveedor proveedor;
    private boolean mostrar;

    private String mensaje;

    @Autowired
    private ProveedorServicio proveedorServicio;

    @PostConstruct
    public void init() {

        Proveedor proveedorObtenido = (Proveedor) getParamInFlashContext(PROVEEDOR);
        if (proveedorObtenido != null) {
            proveedor = proveedorObtenido;

        } else {
            inicializar();

        }

    }

    public void inicializar() {
        proveedor = new Proveedor();
        mensaje = "";
        mostrar = Boolean.FALSE;

    }

    public void guardarProveedor() {

        if (proveedor.getId() == null) {
            proveedorServicio.guardar(proveedor);
        } else {
            proveedorServicio.actualizar(proveedor);
        }

//        productoServicio.guardar(producto);
        mensaje = "Se guardo con éxito";
        mostrar = Boolean.TRUE;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
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
