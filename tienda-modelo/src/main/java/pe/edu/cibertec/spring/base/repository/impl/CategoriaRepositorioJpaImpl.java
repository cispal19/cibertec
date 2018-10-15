package pe.edu.cibertec.spring.base.repository.impl;

import org.springframework.stereotype.Repository;
import pe.edu.cibertec.spring.base.dominio.Categoria;
import pe.edu.cibertec.spring.base.repository.CategoriaRepositorio;

@Repository
public class CategoriaRepositorioJpaImpl
        extends RepositorioBaseJpaImpl<Categoria>
    implements CategoriaRepositorio {

}
