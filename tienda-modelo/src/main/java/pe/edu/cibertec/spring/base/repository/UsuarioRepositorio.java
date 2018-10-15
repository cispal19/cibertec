package pe.edu.cibertec.spring.base.repository;

import pe.edu.cibertec.spring.base.dominio.Usuario;

public interface UsuarioRepositorio
        extends Repositorio<Usuario> {
    
       Usuario login(String usuario, String contrasena);
    
}
