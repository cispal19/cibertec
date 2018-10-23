/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.spring.base.service.impl;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.spring.base.dominio.Producto;
import pe.edu.cibertec.spring.base.dominio.ProductoSku;
import pe.edu.cibertec.spring.base.repository.ProductoRepositorio;
import pe.edu.cibertec.spring.base.repository.Repositorio;
import pe.edu.cibertec.spring.base.service.ProductoServicio;
import pe.edu.cibertec.spring.base.service.ProductoSkuServicio;

/**
 *
 * @author JCISNEROSP
 */
@Service
public class ProductoServiceImpl extends ServicioBase<Producto> implements ProductoServicio {

    private ProductoRepositorio productoRepositorio;

    @Autowired
    private ProductoSkuServicio productoSkuServicio;

    public ProductoServiceImpl(ProductoRepositorio productoRepositorio) {
        super(productoRepositorio);
        this.productoRepositorio = productoRepositorio;
    }

    @Transactional
    @Override
    public void crearProducto(Producto producto) {
        if (producto != null) {
            productoRepositorio.guardar(producto);
            ProductoSku productoSku = new ProductoSku();
            productoSku.setActivo("0");
            productoSku.setCantidad(0);
            productoSku.setPrecio(BigDecimal.ZERO);
            productoSku.setProducto(producto);
            productoSkuServicio.guardar(productoSku);

        }
    }

}
