/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.spring.base.service;

import java.util.List;
import pe.edu.cibertec.spring.base.dominio.Compra;
import pe.edu.cibertec.spring.base.dominio.DetalleCompra;
import pe.edu.cibertec.spring.base.dominio.Producto;

/**
 *
 * @author julio
 */
public interface CompraServicio extends Servicio<Compra>{
    
    public Compra realizarCompra(List<DetalleCompra> items,Compra compra);
    List<Compra> listarCompra(Compra compra);
}
