/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cispal.siscolegio.repository;

import java.util.List;

/**
 *
 * @author JCISNEROSP
 */
public interface RepositoryGeneric<T> {

    public void guardar(T t);

    public void eliminar(T t);

    public void actualizar(T t);

    public T obtener(T t);

    public List<T> listarAll();

    public List<T> listarAll(T t);

}
