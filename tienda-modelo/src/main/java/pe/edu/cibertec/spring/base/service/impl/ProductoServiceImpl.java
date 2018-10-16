/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.spring.base.service.impl;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.spring.base.dominio.Producto;
import pe.edu.cibertec.spring.base.repository.ProductoRepositorio;
import pe.edu.cibertec.spring.base.repository.Repositorio;
import pe.edu.cibertec.spring.base.service.ProductoServicio;

/**
 *
 * @author JCISNEROSP
 */
@Service
public class ProductoServiceImpl extends ServicioBase<Producto> implements ProductoServicio{
    
    private ProductoRepositorio productoRepositorio;

    public ProductoServiceImpl(ProductoRepositorio productoRepositorio) {
        super(productoRepositorio);
        this.productoRepositorio=productoRepositorio;
    }
    
    
    
}
