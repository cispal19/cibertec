package pe.edu.cibertec.spring.base.repository.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.core.GenericTypeResolver;
import pe.edu.cibertec.spring.base.repository.Repositorio;

public abstract class RepositorioBaseJpaImpl<E> implements Repositorio<E> {

    @PersistenceContext
    protected EntityManager em;

    protected Class<E> claseEntidad;

    public RepositorioBaseJpaImpl() {
        claseEntidad = (Class<E>) GenericTypeResolver
                .resolveTypeArguments(getClass(), 
                        RepositorioBaseJpaImpl.class)[0];
    }

    @Override
    public void guardar(E entidad) {
        em.persist(entidad);
    }

    @Override
    public void actualizar(E entidad) {
        em.merge(entidad);
    }

    @Override
    public void eliminar(E entidad) {
        em.remove(entidad);
    }

    @Override
    public E obtenerPorId(Integer id) {
        return em.find(claseEntidad, id);
    }

    @Override
    public List<E> obtenerTodos() {
        CriteriaBuilder cb = em.getCriteriaBuilder();  
        CriteriaQuery<E> query = cb.createQuery(claseEntidad);
        Root<E> root = query.from(claseEntidad);
        TypedQuery<E> tquery = em.createQuery(query.select(root));
        return tquery.getResultList();
    }
}
