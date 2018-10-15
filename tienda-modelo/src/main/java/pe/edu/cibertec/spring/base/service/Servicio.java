package pe.edu.cibertec.spring.base.service;

import java.util.List;

public interface Servicio<E> {

    void guardar(E entidad);
    void actualizar(E entidad);
    void eliminar(E entidad);
    E obtenerPorId(Integer id);
    List<E> obtenerTodos();

}
