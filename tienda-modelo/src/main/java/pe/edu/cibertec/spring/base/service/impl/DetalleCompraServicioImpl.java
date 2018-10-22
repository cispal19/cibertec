/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.spring.base.service.impl;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.spring.base.dominio.DetalleCompra;
import pe.edu.cibertec.spring.base.repository.DetalleCompraRespositorio;
import pe.edu.cibertec.spring.base.service.DetalleCompraServicio;

/**
 *
 * @author julio
 */
@Service
public class DetalleCompraServicioImpl extends ServicioBase<DetalleCompra> implements DetalleCompraServicio{

    public DetalleCompraServicioImpl(DetalleCompraRespositorio detalleCompraRespositorio) {
        super(detalleCompraRespositorio);
    }
    
    
    
}
