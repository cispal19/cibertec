package com.joedayz.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class UsuarioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Integer> usuariosFiltrados;
	
	@PostConstruct
	public void init(){
		
		System.out.println("entro al postcontructor");
		
	}
	
	public List<Integer> getUsuariosFiltrados() {
		return usuariosFiltrados;
	}
	
	public UsuarioBean(){
		usuariosFiltrados = new ArrayList<Integer>();
		for(int i=0;i<20;i++){
			usuariosFiltrados.add(i);
		}
	}
	
	

	public void registrarUsuario(){
		throw new RuntimeException("Ejemplo de excepcion");
	}
	
}
