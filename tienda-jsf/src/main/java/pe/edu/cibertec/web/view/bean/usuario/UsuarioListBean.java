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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.spring.base.dominio.Producto;
import pe.edu.cibertec.spring.base.dominio.Usuario;
import pe.edu.cibertec.spring.base.service.ProductoServicio;
import pe.edu.cibertec.spring.base.service.UsuarioServicio;
import pe.edu.cibertec.web.view.configuracion.GenericController;

/**
 *
 * @author JCISNEROSP
 */
@Component
@Scope("view")
public class UsuarioListBean extends GenericController implements Serializable{

    @Autowired
    private UsuarioServicio usuarioServicio;

    private Usuario usuario;
    private List<Usuario> listaUsuario;

    @PostConstruct
    public void init() {
        inicializar();
        listaUsuario = usuarioServicio.obtenerTodos();

    }

    private void inicializar() {
        usuario = new Usuario();
        listaUsuario = new ArrayList<>();
    }

    public String nuevo() {
        return "/pages/usuario/usuarioForm?faces-redirect=true";

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

  
    

}
