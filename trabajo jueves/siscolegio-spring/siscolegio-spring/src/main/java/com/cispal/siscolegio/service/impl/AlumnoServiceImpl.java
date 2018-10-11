/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cispal.siscolegio.service.impl;

import com.cispal.siscolegio.domain.Alumno;
import com.cispal.siscolegio.repository.AlumnoRepository;
 
import com.cispal.siscolegio.service.AlumnoService;
import java.util.List;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author JCISNEROSP
 */
@Service
public class AlumnoServiceImpl extends ServiceGnericImpl<Alumno> implements AlumnoService{

    private AlumnoRepository alumnoRepositori;
    public AlumnoServiceImpl(AlumnoRepository alumnoRepository) {
        super(alumnoRepository);
        this.alumnoRepositori=alumnoRepository;
    }

    @Cacheable(cacheNames="alumnoCache")
    @Transactional
    @Override
    public Alumno getAlumnoByDni(String dni) {
        return alumnoRepositori.getAlumnoByDni(dni);
    }

    @Transactional
    @Override
    public List<Alumno> listarParametro(Alumno alumno) {
       return alumnoRepositori.listarParametro(alumno);
    }
    
    
}
