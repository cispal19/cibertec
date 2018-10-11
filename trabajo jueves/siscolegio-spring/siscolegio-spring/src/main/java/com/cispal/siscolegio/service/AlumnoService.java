/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cispal.siscolegio.service;

import com.cispal.siscolegio.domain.Alumno;

/**
 *
 * @author JCISNEROSP
 */
public interface AlumnoService extends ServiceGeneric<Alumno>{
     Alumno getAlumnoByDni(String dni);
}
