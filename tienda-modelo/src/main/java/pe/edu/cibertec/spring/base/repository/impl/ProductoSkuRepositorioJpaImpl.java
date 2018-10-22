package pe.edu.cibertec.spring.base.repository.impl;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import pe.edu.cibertec.spring.base.dominio.ProductoSku;
import pe.edu.cibertec.spring.base.repository.ProductoSkuRepositorio;
import pe.edu.cibertec.spring.base.repository.impl.util.JpaQueryUtil;

@Repository
public class ProductoSkuRepositorioJpaImpl
        extends RepositorioBaseJpaImpl<ProductoSku>
        implements ProductoSkuRepositorio {

    @Override
    public ProductoSku obtenerPorIdProducto(Integer idProducto) {
        String hql = "SELECT p FROM ProductoSku p WHERE p.producto.id = :idProducto AND p.activo = '1'";
        TypedQuery<ProductoSku> query = em.createQuery(hql, ProductoSku.class);
        return JpaQueryUtil.obtenerUnicoResultado(query);
    }

    @Override
    public void actualizarCantidad(int id, int cantidad) {

        String sql = "update producto_sku set cantidad =cantidad + #cantidad where producto_id=#id";
        Query query = em.createNativeQuery(sql);
        query.setParameter("id", id);
        query.setParameter("cantidad", cantidad);
        query.executeUpdate();
    }
}
