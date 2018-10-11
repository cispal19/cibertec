/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cispal.siscolegio.repository.impl;

import com.cispal.siscolegio.repository.RepositoryGeneric;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.core.GenericTypeResolver;

/**
 *
 * @author JCISNEROSP
 */
public abstract class RepositoryGenericImpl<T> implements RepositoryGeneric<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    protected Class<T> claseEntidad;

    public RepositoryGenericImpl() {
        claseEntidad = (Class<T>) GenericTypeResolver
                .resolveTypeArguments(getClass(),
                        RepositoryGenericImpl.class)[0];
    }

    @Override
    public void guardar(T t) {
        entityManager.persist(t);
    }

    @Override
    public void eliminar(T t) {
        entityManager.remove(t);
    }

    @Override
    public void actualizar(T t) {
        entityManager.merge(t);
    }

    @Override
    public T obtener(T t) {
        return entityManager.find(claseEntidad, t);
    }

    @Override
    public List<T> listarAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(claseEntidad);
        Root<T> root = query.from(claseEntidad);
        TypedQuery<T> tquery = entityManager.createQuery(query.select(root));
        return tquery.getResultList();

    }

    @Override
    public List<T> listarAll(T t) {
        return null;
    }

}
