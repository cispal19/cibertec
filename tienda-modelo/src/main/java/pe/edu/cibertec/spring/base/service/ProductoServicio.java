package pe.edu.cibertec.spring.base.service;

import pe.edu.cibertec.spring.base.dominio.Producto;

public interface ProductoServicio extends Servicio<Producto> {
    
    void crearProducto(Producto producto);
    
}
