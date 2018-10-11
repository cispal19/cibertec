/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cispal.siscolegio.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author JCISNEROSP
 */
@Entity
public class Profesor implements Serializable{
    
    @Id
    private int idprofesor;
    private String apellidos;
    private String nombres;
    private String dni;
    private String direccion;
    private String telefono;
    private String email;
    private String password;
    @OneToMany(mappedBy = "profesor")
    private List<Curso> listanotas;

    public Profesor(int idprofesor, String apellidos, String nombres, String dni, String direccion, String telefono, String email, String password, List<Curso> listanotas) {
        this.idprofesor = idprofesor;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
        this.listanotas = listanotas;
    }

  

    public int getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(int idprofesor) {
        this.idprofesor = idprofesor;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Curso> getListanotas() {
        return listanotas;
    }

    public void setListanotas(List<Curso> listanotas) {
        this.listanotas = listanotas;
    }
    
    
    
    
}
