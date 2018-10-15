package pe.edu.cibertec.spring.base.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import static org.springframework.util.CollectionUtils.isEmpty;
import pe.edu.cibertec.spring.base.dominio.DetalleVenta;
import pe.edu.cibertec.spring.base.dominio.Producto;
import pe.edu.cibertec.spring.base.dominio.ProductoSku;
import pe.edu.cibertec.spring.base.dominio.Usuario;
import pe.edu.cibertec.spring.base.dominio.Venta;
import pe.edu.cibertec.spring.base.service.FacturacionServicio;
import pe.edu.cibertec.spring.base.service.ProductoSkuServicio;
import pe.edu.cibertec.spring.base.service.VentaServicio;

@Service
public class FacturacionServicioImpl implements FacturacionServicio {

    private ProductoSkuServicio productoSkuServicio;
    private VentaServicio ventaServicio;

    public FacturacionServicioImpl(ProductoSkuServicio productoSkuServicio,
            VentaServicio ventaServicio) {
        this.productoSkuServicio = productoSkuServicio;
        this.ventaServicio = ventaServicio;
    }

    private boolean revisarStock(Producto producto) {
        ProductoSku skuActivo = producto.getListaSkus().stream()
                .filter(sku -> "1".equals(sku.getActivo()))
                .findFirst().get();

        ProductoSku skuActual = productoSkuServicio.obtenerPorId(skuActivo.getId());
        return skuActual.getCantidad() >= skuActivo.getCantidad();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Venta generarVenta(Usuario usuario, List<Producto> listaProducto) {
        if (isEmpty(listaProducto)) {
            throw new IllegalArgumentException("Lista de productos vacía");
        }
        if (listaProducto.stream().filter(this::revisarStock).findFirst().isPresent()) {
            throw new IllegalArgumentException("Stock insuficiente para la orden");
        }
        Venta venta = new Venta();
        venta.setUsuario(usuario);
        BigDecimal subtotal = BigDecimal.ZERO;
        BigDecimal impuestos = BigDecimal.ZERO;
        List<DetalleVenta> listaDetalleVenta = new LinkedList<>();

        for (Producto producto : listaProducto) {
            ProductoSku skuActivo = producto.getListaSkus().stream()
                .filter(sku -> "1".equals(sku.getActivo()))
                .findFirst().get();

            DetalleVenta detalleVenta = new DetalleVenta();
            detalleVenta.setVenta(venta);
            ProductoSku skuActual = productoSkuServicio.obtenerPorId(
                    skuActivo.getId());
            detalleVenta.setProductoSku(skuActual);
            detalleVenta.setPrecioUnitario(skuActual.getPrecio());
            detalleVenta.setCantidad(skuActivo.getCantidad());

            skuActual.setCantidad(skuActual.getCantidad() -
                    skuActivo.getCantidad());
            productoSkuServicio.guardar(skuActual);
            subtotal = subtotal.add(
                    detalleVenta.getPrecioUnitario().multiply(
                            new BigDecimal(skuActual.getCantidad())));
        }

        BigDecimal total = subtotal.add(impuestos);
        venta.setSubtotal(subtotal);
        venta.setImpuestos(impuestos);
        venta.setTotal(total);
        venta.setFechaVenta(new Date()); //java.util.Date
        venta.setListaDetalleVenta(listaDetalleVenta);

        ventaServicio.guardar(venta);
        return venta;
    }

}
