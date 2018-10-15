package pe.edu.cibertec.spring.base.repository.impl;

import org.springframework.stereotype.Repository;
import pe.edu.cibertec.spring.base.dominio.Producto;
import pe.edu.cibertec.spring.base.repository.ProductoRepositorio;

@Repository
public class ProductoRepositorioJpaImpl
    extends RepositorioBaseJpaImpl<Producto>
    implements ProductoRepositorio {

}
