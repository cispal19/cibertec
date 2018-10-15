/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.web.view.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author JCISNEROSP
 */
@Component
@Scope("view")
public class MenuBean {

    public String producto() {
        return "/pages/producto/productos?faces-redirect=true";
    }

    public String venta() {
        return "/pages/venta/detalle-producto?faces-redirect=true";
    }

    public String inicio() {
        return "/principal?faces-redirect=true";
    }

}
