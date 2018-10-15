/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.web.view.bean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.spring.base.dominio.Usuario;
import pe.edu.cibertec.spring.base.service.UsuarioServicio;

/**
 *
 * @author JCISNEROSP
 */
@Component
@Scope("session")
public class LoginBean implements Serializable{
    
    @Autowired
    private UsuarioServicio usuarioServicio;
    
    private Usuario usuario;
    private String nombreUsuario;
    private String contrasena;
    
    
    
    @PostConstruct
    public void init(){
    usuario = new Usuario();
    }
    
    public String login(){
    usuario = usuarioServicio.login(nombreUsuario, contrasena);
        if (usuario != null && usuario.getCorreoElectronico() != null) {
            
            return "principal";
        }
        return "login";
    
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    
    
}
