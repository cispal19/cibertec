/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cispal.siscolegio.repository;

import com.cispal.siscolegio.domain.Alumno;
import java.util.List;

/**
 *
 * @author JCISNEROSP
 */
public interface AlumnoRepository extends RepositoryGeneric<Alumno>{
    
    Alumno getAlumnoByDni(String dni);
    List<Alumno> listarParametro(Alumno alumno);
   
}
