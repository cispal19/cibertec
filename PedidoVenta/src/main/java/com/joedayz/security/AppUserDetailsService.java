package com.joedayz.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.joedayz.modelo.Grupo;
import com.joedayz.modelo.Usuario;
import com.joedayz.repositorio.UsuarioRepositorio;
import com.joedayz.util.cdi.CDIServiceLocator;

public class AppUserDetailsService implements UserDetailsService{

	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UsuarioRepositorio usuarioRepositorio = CDIServiceLocator.getBean(UsuarioRepositorio.class);
		Usuario usuario = usuarioRepositorio.buscarUsuarioporEmail(email);
		UsuarioSistema user = null;
		if(usuario!=null){
			user = new UsuarioSistema(usuario, getGrupos(usuario));
		}
		
		return user;
	}

	private Collection<? extends GrantedAuthority> getGrupos(Usuario usuario) {

		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		
		for(Grupo grupo : usuario.getGrupos()){
			authorities.add(new SimpleGrantedAuthority(grupo.getNombreGrupo().toUpperCase()));
		}
		
		return authorities;
	}

}
