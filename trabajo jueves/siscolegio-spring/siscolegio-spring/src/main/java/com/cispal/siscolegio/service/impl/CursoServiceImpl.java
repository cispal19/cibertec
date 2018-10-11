/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cispal.siscolegio.service.impl;

import com.cispal.siscolegio.domain.Curso;
import com.cispal.siscolegio.domain.Notas;
import com.cispal.siscolegio.repository.CursoRepository;
import com.cispal.siscolegio.repository.RepositoryGeneric;
import com.cispal.siscolegio.service.CursoService;
import org.springframework.stereotype.Service;

/**
 *
 * @author JCISNEROSP
 */
@Service
public class CursoServiceImpl extends ServiceGnericImpl<Curso> implements CursoService{

    private CursoRepository cursoRepository;
    public CursoServiceImpl(CursoRepository cursoRepository) {
        super(cursoRepository);
        this.cursoRepository=cursoRepository;
    }

  
    
    
    
}
