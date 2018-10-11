/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cispal.siscolegio.service.impl;

import com.cispal.siscolegio.domain.Alumno;
import com.cispal.siscolegio.repository.AlumnoRepository;
import com.cispal.siscolegio.repository.RepositoryGeneric;
import com.cispal.siscolegio.service.AlumnoService;
import org.springframework.stereotype.Service;

/**
 *
 * @author JCISNEROSP
 */
@Service
public class AlumnoServiceImpl extends ServiceGnericImpl<Alumno> implements AlumnoService{

    public AlumnoServiceImpl(AlumnoRepository alumnoRepository) {
        super(alumnoRepository);
    }
    
    
}
