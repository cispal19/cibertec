/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.web.view.bean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author JCISNEROSP
 */
@Component
@Scope("view")
public class MenuBean implements Serializable {

    private String nombre;

    @PostConstruct
    public void init() {
        nombre = "";
    }

    public String producto() {
        nombre = "Producto";
        return "/pages/producto/productos?faces-redirect=true";
    }

    public String productoNuevo() {
        nombre = "Producto Nuevo";
        return "/pages/producto/productoForm?faces-redirect=true";
    }

    public String productoStock() {
        nombre = "Producto Nuevo";
        return "/pages/stock/productoStock?faces-redirect=true";
    }
    
     public String usuario() {
       
        return "/pages/usuario/usuarioList?faces-redirect=true";
    }

    public String productoPrecio() {
        nombre = "Producto Nuevo";
        return "/pages/stock/productoPrecio?faces-redirect=true";
    }

    public String venta() {
        nombre = "Venta";
        return "/pages/venta/detalle-producto?faces-redirect=true";
    }

    public String inicio() {
        nombre = "Dashboard";
        return "/principal?faces-redirect=true";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String proveedor(){
    return "/pages/proveedor/proveedores?faces-redirect=true";
    }
    
    public String proveedorNuevo(){
    return "/pages/proveedor/proveedorForm?faces-redirect=true";
    
    }
    
      
    public String logout(){
    return "/logout";
    
    }
    
     public String compra() {
        nombre = "Venta";
        return "/pages/compra/compraList?faces-redirect=true";
    }

}
