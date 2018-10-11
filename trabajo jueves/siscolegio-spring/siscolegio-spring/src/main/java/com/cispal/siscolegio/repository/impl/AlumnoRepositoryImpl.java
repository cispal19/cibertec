/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cispal.siscolegio.repository.impl;

import com.cispal.siscolegio.domain.Alumno;
import com.cispal.siscolegio.repository.AlumnoRepository;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JCISNEROSP
 */
@Repository
public class AlumnoRepositoryImpl extends RepositoryGenericImpl<Alumno> implements AlumnoRepository {

    @Override
    public Alumno getAlumnoByDni(String dni) {
        Session session = (Session) entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Alumno.class);

        if (StringUtils.isNotBlank(dni)) {
            criteria.add(Restrictions.eq("dni", dni));
        }

        Alumno alumnoOBtenido = (Alumno) criteria.uniqueResult();

        if (alumnoOBtenido == null) {
            alumnoOBtenido = new Alumno();
        }

        return alumnoOBtenido;

    }

    @Override
    public List<Alumno> listarParametro(Alumno alumno) {
        Session session = (Session) entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Alumno.class);

        if (StringUtils.isNotBlank(alumno.getDni())) {
            criteria.add(Restrictions.eq("dni", alumno.getDni()));
        }

        if (StringUtils.isNotBlank(alumno.getNombres())) {
            criteria.add(Restrictions.like("nombres", alumno.getNombres(), MatchMode.ANYWHERE).ignoreCase());
        }
        if (StringUtils.isNotBlank(alumno.getApellidos())) {
            criteria.add(Restrictions.like("apellidos", alumno.getApellidos(), MatchMode.ANYWHERE).ignoreCase());
        }

        List<Alumno> lista = criteria.list();
        return lista;
    }



}
