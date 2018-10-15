package pe.edu.cibertec.spring.base.service;

import pe.edu.cibertec.spring.base.dominio.ProductoSku;

public interface ProductoSkuServicio
    extends Servicio<ProductoSku> {

    ProductoSku obtenerPorIdProducto(Integer idProducto);
}
