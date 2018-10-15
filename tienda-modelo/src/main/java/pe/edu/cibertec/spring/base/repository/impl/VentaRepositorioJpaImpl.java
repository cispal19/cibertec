package pe.edu.cibertec.spring.base.repository.impl;

import org.springframework.stereotype.Repository;
import pe.edu.cibertec.spring.base.dominio.Venta;
import pe.edu.cibertec.spring.base.repository.VentaRepositorio;

@Repository
public class VentaRepositorioJpaImpl
    extends RepositorioBaseJpaImpl<Venta>
    implements VentaRepositorio {

}
