package pe.edu.cibertec.spring.base.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.spring.base.dominio.Usuario;
import pe.edu.cibertec.spring.base.repository.UsuarioRepositorio;
import pe.edu.cibertec.spring.base.service.UsuarioServicio;

@Service
public class UsuarioServicioImpl
    extends ServicioBase<Usuario>
    implements UsuarioServicio {
    
    private UsuarioRepositorio usuarioRepositorio;

    public UsuarioServicioImpl(
            UsuarioRepositorio usuarioRepositorio) {
        super(usuarioRepositorio);
        this.usuarioRepositorio=usuarioRepositorio;
    }

    @Transactional
    @Override
    public Usuario login(String usuario, String contrasena) {
       return usuarioRepositorio.login(usuario, contrasena);
    }
}
