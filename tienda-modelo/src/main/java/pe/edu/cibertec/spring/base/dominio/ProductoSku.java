package pe.edu.cibertec.spring.base.dominio;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import pe.edu.cibertec.spring.base.dominio.base.Entidad;

@Entity
@Table(name= "producto_sku")
public class ProductoSku extends Entidad {

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
    private String activo;
    private BigDecimal precio;
    private int cantidad;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
