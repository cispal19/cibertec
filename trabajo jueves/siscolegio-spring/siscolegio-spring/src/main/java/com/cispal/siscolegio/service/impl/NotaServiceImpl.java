/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cispal.siscolegio.service.impl;

import com.cispal.siscolegio.domain.Notas;
import com.cispal.siscolegio.repository.NotaRepository;

import com.cispal.siscolegio.service.NotaService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author JCISNEROSP
 */
@Service
public class NotaServiceImpl extends ServiceGnericImpl<Notas> implements NotaService {

    private NotaRepository notaRepository;

    public NotaServiceImpl(NotaRepository notaRepository) {
        super(notaRepository);
        this.notaRepository = notaRepository;
    }

    @Transactional
    @Override
    public List<Notas> consultarNotaByDniAlumno(Notas notas) {
        return notaRepository.consultarNotaByDniAlumno(notas);
    }

}
