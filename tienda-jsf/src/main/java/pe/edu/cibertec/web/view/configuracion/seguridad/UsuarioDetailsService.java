/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.web.view.configuracion.seguridad;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.spring.base.dominio.Usuario;
import pe.edu.cibertec.spring.base.service.UsuarioServicio;

/**
 *
 * @author JCISNEROSP
 */
@Service("usuarioDetailsService")
public class UsuarioDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioServicio.login(username, null);
        if (usuario.getNombre() == null) {
            Usuario usuarioNuevo = new Usuario();
           
            usuarioNuevo.setNombre("julio");
            usuarioNuevo.setCorreoElectronico("cispal19@gmail.com");
            usuarioNuevo.setContrasena("123");
            usuarioServicio.saveUsuario(usuario);
            throw new UsernameNotFoundException("Username not found");
        }
        return new User(usuario.getNombre(), usuario.getContrasena(),getGrantedAuthorities());
    }

    private List<GrantedAuthority> getGrantedAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        return authorities;
    }

}
