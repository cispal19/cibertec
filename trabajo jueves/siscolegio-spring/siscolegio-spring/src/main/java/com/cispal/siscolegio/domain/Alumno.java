/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cispal.siscolegio.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author JCISNEROSP
 */
@Entity
public class Alumno implements Serializable{
    
    @Id
    @GeneratedValue
    private int idalumno;
    private String apellidos;
    private String nombres;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechanacimiento;
    private String sexo;
    private String direccion;
    private String telefono;
    private String email;
    private String dni;
    private String grado;
    private String seccion;
    @OneToMany(mappedBy = "alumno")
    private List<Notas> listanotas;

    public Alumno() {
    }
    
    

    public Alumno(int idalumno, String apellidos, String nombres, Date fechanacimiento, String sexo, String direccion, String telefono, String email, String dni, String grado, String seccion, List<Notas> listanotas) {
        this.idalumno = idalumno;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.fechanacimiento = fechanacimiento;
        this.sexo = sexo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.dni = dni;
        this.grado = grado;
        this.seccion = seccion;
        this.listanotas = listanotas;
    }




    public int getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(int idalumno) {
        this.idalumno = idalumno;
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

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public List<Notas> getListanotas() {
        return listanotas;
    }

    public void setListanotas(List<Notas> listanotas) {
        this.listanotas = listanotas;
    }

    @Override
    public String toString() {
        return "Alumno{" + "idalumno=" + idalumno + ", apellidos=" + apellidos + ", nombres=" + nombres + ", fechanacimiento=" + fechanacimiento + ", sexo=" + sexo + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email + ", dni=" + dni + ", grado=" + grado + ", seccion=" + seccion + ", listanotas=" + listanotas + '}';
    }

    
    
}
