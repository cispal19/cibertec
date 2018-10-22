package pe.edu.cibertec.spring.base.repository;

import pe.edu.cibertec.spring.base.dominio.ProductoSku;

public interface ProductoSkuRepositorio
    extends Repositorio<ProductoSku> {

    ProductoSku obtenerPorIdProducto(Integer idProducto);
    
   void actualizarCantidad(int id,int cantidad);

}
