/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.spring.base.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.spring.base.dominio.Compra;
import pe.edu.cibertec.spring.base.dominio.DetalleCompra;
import pe.edu.cibertec.spring.base.dominio.Producto;
import pe.edu.cibertec.spring.base.dominio.ProductoSku;
import pe.edu.cibertec.spring.base.dominio.Proveedor;
import pe.edu.cibertec.spring.base.repository.CompraRepositorio;

import pe.edu.cibertec.spring.base.service.CompraServicio;
import pe.edu.cibertec.spring.base.service.DetalleCompraServicio;
import pe.edu.cibertec.spring.base.service.ProductoSkuServicio;

/**
 *
 * @author julio
 */
@Service
public class CompraServicioImpl extends ServicioBase<Compra> implements CompraServicio {

    private CompraRepositorio compraRepositorio;

    @Autowired
    private ProductoSkuServicio productoSkuServicio;

    @Autowired
    private DetalleCompraServicio detalleCompraServicio;

    public CompraServicioImpl(CompraRepositorio compraRepositorio) {
        super(compraRepositorio);
        this.compraRepositorio = compraRepositorio;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Compra realizarCompra(List<DetalleCompra> items, Compra compra) {
        Compra compraGuardada = new Compra();
        compraGuardada = compra;
        compraGuardada.setDocumento("10700763647");
        compraGuardada.setListaDetalleCompra(items);

        for (DetalleCompra detalle : items) {
            productoSkuServicio.actualizarCantidad(detalle.getProducto().getId(), detalle.getCantidad());
        }

        compraRepositorio.guardar(compraGuardada);

        return compraGuardada;

    }

    @Transactional
    @Override
    public List<Compra> listarCompra(Compra compra) {
        return compraRepositorio.listarCompra(compra);
    }

}
