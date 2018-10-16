/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.web.view.bean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.spring.base.dominio.ProductoSku;
import pe.edu.cibertec.spring.base.service.ProductoSkuServicio;
import pe.edu.cibertec.web.view.configuracion.GenericController;

/**
 *
 * @author JCISNEROSP
 */
@Component
@Scope("view")
public class ProductoPrecioForm extends GenericController implements Serializable {

    @Autowired
    private ProductoSkuServicio productoSkuServicio;

    private ProductoSku productoSku;
    
    private String mensaje;

    @PostConstruct
    public void init() {
        mensaje="";
        ProductoSku productoSkuObtenido = (ProductoSku) getParamInFlashContext(PRODUCTO_SKU);

        if (productoSkuObtenido != null) {
            productoSku = productoSkuObtenido;

        } else {
            productoSku = new ProductoSku();
        }

    }

    public void btnGuardar() {
        if (productoSku.getId() == 0) {
            productoSkuServicio.guardar(productoSku);
            mensaje="Se guardo con éxito";

        } else {
            productoSkuServicio.actualizar(productoSku);
             mensaje="Se actualizo con éxito";
        }
    }

    public ProductoSku getProductoSku() {
        return productoSku;
    }

    public void setProductoSku(ProductoSku productoSku) {
        this.productoSku = productoSku;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    

    
    
}
