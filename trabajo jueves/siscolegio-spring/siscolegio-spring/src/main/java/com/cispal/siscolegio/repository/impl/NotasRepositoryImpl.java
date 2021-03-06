/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cispal.siscolegio.repository.impl;

import com.cispal.siscolegio.domain.Notas;
import com.cispal.siscolegio.repository.NotaRepository;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JCISNEROSP
 */
@Repository
public class NotasRepositoryImpl extends RepositoryGenericImpl<Notas> implements NotaRepository {

    @Override
    public List<Notas> consultarNotaByDniAlumno(Notas notas) {
        Session session = (Session) entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Notas.class);
        criteria.createCriteria("alumno", "alumno", JoinType.INNER_JOIN);
        criteria.createCriteria("curso", "curso", JoinType.INNER_JOIN);

        if (notas != null && notas.getAlumno() != null && notas.getAlumno().getDni() != null) {
            criteria.add(Restrictions.eq("alumno.dni", notas.getAlumno().getDni()));
        }

        List<Notas> lista = criteria.list();

        return lista;

    }

    @Override
    public Notas consultarNotaByDniCursoBimestre(Notas notas) {
        Session session = (Session) entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Notas.class);
        criteria.createCriteria("alumno", "alumno", JoinType.INNER_JOIN);
        criteria.createCriteria("curso", "curso", JoinType.INNER_JOIN);

        if (notas != null && notas.getAlumno() != null && notas.getAlumno().getDni() != null) {
            criteria.add(Restrictions.eq("alumno.dni", notas.getAlumno().getDni()));
        }
        if (notas != null && notas.getCurso() != null && notas.getCurso().getIdcurso() != 0) {
            criteria.add(Restrictions.eq("curso.idcurso", notas.getCurso().getIdcurso()));
        }
        
        if (StringUtils.isNotBlank(notas.getUnidad())) {
            criteria.add(Restrictions.eq("unidad", notas.getUnidad()));
        }

        Notas notaObtenida =(Notas) criteria.uniqueResult();

        return notaObtenida;
    }

}
