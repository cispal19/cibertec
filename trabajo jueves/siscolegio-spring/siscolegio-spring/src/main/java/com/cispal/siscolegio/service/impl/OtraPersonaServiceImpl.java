package com.cispal.siscolegio.service.impl;

import com.cispal.siscolegio.domain.Persona;
import com.cispal.siscolegio.repository.OtraPersonaRepository;

import com.cispal.siscolegio.service.OtraPersonaService;

import org.springframework.stereotype.Service;



@Service
public class OtraPersonaServiceImpl extends ServiceGnericImpl<Persona>
    implements OtraPersonaService {

    public OtraPersonaServiceImpl(OtraPersonaRepository otraPersonaRepository) {
        super(otraPersonaRepository);
    }
    
    

//    private final OtraPersonaRepository otraPersonaRepository;
//
//    public OtraPersonaServiceImpl(OtraPersonaRepository otraPersonaRepository) {
//        this.otraPersonaRepository = otraPersonaRepository;
//    }
//
//    @Transactional
//    @Override
//    public void guardar(Persona persona) {
//        otraPersonaRepository.guardar(persona);
//    }
//
//    @Override
//    public List<Persona> obtenerTodos() {
//        return otraPersonaRepository.obtenerTodos();
//    }

    
}
