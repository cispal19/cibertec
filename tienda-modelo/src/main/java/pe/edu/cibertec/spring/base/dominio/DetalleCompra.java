/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.spring.base.dominio;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import pe.edu.cibertec.spring.base.dominio.base.Entidad;

/**
 *
 * @author julio
 */
@Entity
@Table(name = "detalle_compra")
public class DetalleCompra extends Entidad {

    @OneToOne(optional = false)
    @JoinColumn(name = "idproducto")
    private Producto producto;

    private int cantidad;
    private double precio;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idcompra")
    private Compra compra;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

  

}
