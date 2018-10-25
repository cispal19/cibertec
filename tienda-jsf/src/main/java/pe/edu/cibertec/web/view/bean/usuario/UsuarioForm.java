/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.web.view.bean.usuario;

import pe.edu.cibertec.web.view.bean.producto.*;
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
import pe.edu.cibertec.spring.base.dominio.Usuario;
import pe.edu.cibertec.spring.base.service.CategoriaServicio;
import pe.edu.cibertec.spring.base.service.ProductoServicio;
import pe.edu.cibertec.spring.base.service.UsuarioServicio;
import pe.edu.cibertec.web.view.configuracion.GenericController;

/**
 *
 * @author JCISNEROSP
 */
@Component
@Scope("view")
public class UsuarioForm extends GenericController implements Serializable {

    private Usuario usuario;
    private boolean mostrar;
    private String mensaje;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostConstruct
    public void init() {
        usuario = new Usuario();
        mensaje = "";
        mostrar = Boolean.FALSE;
    }

    public void guardarUsuario() {

        usuarioServicio.saveUsuario(usuario);

        mensaje = "Se guardo con éxito";
        mostrar = Boolean.TRUE;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
