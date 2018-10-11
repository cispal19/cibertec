/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cispal.siscolegio.service.impl;

import com.cispal.siscolegio.repository.RepositoryGeneric;
import com.cispal.siscolegio.service.ServiceGeneric;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author JCISNEROSP
 */
public abstract class ServiceGnericImpl<T> implements ServiceGeneric<T>{
    
    protected RepositoryGeneric<T> repositoryGeneric;

    public ServiceGnericImpl(RepositoryGeneric<T> repositoryGeneric) {
        this.repositoryGeneric=repositoryGeneric;
    }
    
    @Transactional
    @Override
    public void guardar(T t) {
        repositoryGeneric.guardar(t);
    }

    @Transactional
    @Override
    public void eliminar(T t) {
       repositoryGeneric.eliminar(t);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void actualizar(T t) {
       repositoryGeneric.actualizar(t);
    }

    @Transactional(readOnly = true)
    @Override
    public T obtener(T t) {
       return repositoryGeneric.obtener(t);
    }

    @Transactional(readOnly = true)
    @Override
    public List<T> listarAll() {
       return repositoryGeneric.listarAll();
    }

    @Override
    public List<T> listarAll(T t) {
       return null;
    }
    
}
