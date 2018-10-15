package pe.edu.cibertec.spring.base.service.impl;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.spring.base.dominio.ProductoSku;
import pe.edu.cibertec.spring.base.repository.ProductoSkuRepositorio;
import pe.edu.cibertec.spring.base.service.ProductoSkuServicio;

@Service
public class ProductoSkuServicioImpl
    extends ServicioBase<ProductoSku>
    implements ProductoSkuServicio {

    public ProductoSkuServicioImpl(ProductoSkuRepositorio productoSkuRepositorio) {
        super(productoSkuRepositorio);
    }

    @Override
    public ProductoSku obtenerPorIdProducto(Integer idProducto) {
        return ((ProductoSkuRepositorio)repositorio).obtenerPorIdProducto(idProducto);
    }
}
