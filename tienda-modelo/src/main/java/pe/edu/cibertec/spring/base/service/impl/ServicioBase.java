package pe.edu.cibertec.spring.base.service.impl;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.spring.base.repository.Repositorio;
import pe.edu.cibertec.spring.base.service.Servicio;

public abstract class ServicioBase<E> implements Servicio<E> {

    protected Repositorio<E> repositorio;

    protected ServicioBase(Repositorio<E> repositorio) {
        this.repositorio = repositorio;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void guardar(E entidad) {
        repositorio.guardar(entidad);
    }

    @Transactional
    @Override
    public void actualizar(E entidad) {
        repositorio.actualizar(entidad);
    }

    @Transactional
    @Override
    public void eliminar(E entidad) {
        repositorio.eliminar(entidad);
    }

    @Transactional(readOnly = true)
    @Override
    public E obtenerPorId(Integer id) {
        return repositorio.obtenerPorId(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<E> obtenerTodos() {
        return repositorio.obtenerTodos();
    }
}
