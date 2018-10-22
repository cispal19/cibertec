/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.spring.base.service;

import pe.edu.cibertec.spring.base.dominio.Proveedor;

/**
 *
 * @author julio
 */
public interface ProveedorServicio extends Servicio<Proveedor>{
    Proveedor getProveedorByRuc(String ruc);
}
