/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.spring.base.service.impl;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.spring.base.dominio.Proveedor;
import pe.edu.cibertec.spring.base.repository.ProveedorRepositorio;
import pe.edu.cibertec.spring.base.service.ProveedorServicio;

/**
 *
 * @author julio
 */
@Service
public class ProveedorServicioImpl extends ServicioBase<Proveedor> implements ProveedorServicio{

    public ProveedorServicioImpl(ProveedorRepositorio proveedorRepositorio) {
        super(proveedorRepositorio);
    }
    
    
    
}
