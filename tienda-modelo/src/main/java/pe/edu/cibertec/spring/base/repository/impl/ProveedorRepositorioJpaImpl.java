/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.spring.base.repository.impl;

import org.springframework.stereotype.Repository;
import pe.edu.cibertec.spring.base.dominio.Proveedor;
import pe.edu.cibertec.spring.base.repository.ProveedorRepositorio;

/**
 *
 * @author julio
 */
@Repository
public class ProveedorRepositorioJpaImpl extends RepositorioBaseJpaImpl<Proveedor> implements ProveedorRepositorio{
    
}
