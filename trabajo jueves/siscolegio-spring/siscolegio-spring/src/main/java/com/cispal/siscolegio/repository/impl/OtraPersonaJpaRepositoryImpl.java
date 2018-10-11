package com.cispal.siscolegio.repository.impl;

import com.cispal.siscolegio.domain.Persona;
import com.cispal.siscolegio.repository.OtraPersonaRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository
public class OtraPersonaJpaRepositoryImpl extends RepositoryGenericImpl<Persona>
    implements OtraPersonaRepository {

//    @PersistenceContext
//    private EntityManager em;
//
//    @Override
//    public void guardar(Persona persona) {
//        em.persist(persona);
//    }
//
//    @Override
//    public List<Persona> obtenerTodos() {
//        return em.createQuery("SELECT p FROM Persona p", Persona.class)
//                .getResultList();
//    }
}
