package pe.edu.cibertec.spring.base.service;

import pe.edu.cibertec.spring.base.dominio.Usuario;

public interface UsuarioServicio
        extends Servicio<Usuario> {
    
    Usuario login(String usuario, String contrasena);
    void saveUsuario(Usuario usuario);
    
}
