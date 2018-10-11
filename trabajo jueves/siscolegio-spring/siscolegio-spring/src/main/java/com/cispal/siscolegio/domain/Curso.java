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
public class Curso implements Serializable{
    
    @Id
    private int idcurso;
    private String nombrecurso;
    @ManyToOne
    @JoinColumn(name="idprofesor")
    private Profesor profesor;

    public Curso() {
    }
    
    

    public Curso(int idcurso, String nombrecurso, Profesor profesor) {
        this.idcurso = idcurso;
        this.nombrecurso = nombrecurso;
        this.profesor = profesor;
    }

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public String getNombrecurso() {
        return nombrecurso;
    }

    public void setNombrecurso(String nombrecurso) {
        this.nombrecurso = nombrecurso;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        return nombrecurso ;
    }

   
    
    
    
    
}
