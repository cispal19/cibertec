package pe.edu.cibertec.spring.base.repository;

import java.util.List;

public interface Repositorio<E> {

    void guardar(E entidad);
    void actualizar(E entidad);
    void eliminar(E entidad);
    E obtenerPorId(Integer id);
    List<E> obtenerTodos();

}
