/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cispal.siscolegio.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author JCISNEROSP
 */
@Entity
public class Notas implements Serializable {

    @Id
    private int idnota;
    @ManyToOne
    @JoinColumn(name = "idcurso")
    private Curso curso;
    @ManyToOne
    @JoinColumn(name = "idalumno")
    private Alumno alumno;
    private String unidad;
    private int promedio;

    public Notas() {
        
    }
    
    

    public Notas(int idnota, Curso curso, Alumno alumno, String unidad, int promedio) {
        this.idnota = idnota;
        this.curso = curso;
        this.alumno = alumno;
        this.unidad = unidad;
        this.promedio = promedio;
    }

    public int getIdnota() {
        return idnota;
    }

    public void setIdnota(int idnota) {
        this.idnota = idnota;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public int getPromedio() {
        return promedio;
    }

    public void setPromedio(int promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Notas{" + "idnota=" + idnota + ", curso=" + curso + ", alumno=" + alumno + ", unidad=" + unidad + ", promedio=" + promedio + '}';
    }
    
    

}
