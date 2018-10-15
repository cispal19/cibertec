package pe.edu.cibertec.spring.base.service.impl;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.spring.base.dominio.Venta;
import pe.edu.cibertec.spring.base.repository.VentaRepositorio;
import pe.edu.cibertec.spring.base.service.VentaServicio;

@Service
public class VentaServicioImpl
    extends ServicioBase<Venta>
    implements VentaServicio {

    public VentaServicioImpl(VentaRepositorio ventaRepositorio) {
        super(ventaRepositorio);
    }
}
