package pe.edu.cibertec.web.view.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pe.edu.cibertec.spring.base.dominio.ProductoSku;
import pe.edu.cibertec.spring.base.service.ProductoSkuServicio;
import pe.edu.cibertec.web.view.configuracion.GenericController;

@Component //@ManagedBean
@Scope("view") //@ViewScoped
public class ListaProductoBean extends GenericController implements Serializable{

    private List<ProductoSku> listaProductoSku;

    @Autowired
    private ProductoSkuServicio productoSkuServicio;
    
    private ProductoSku productoSku;

    @PostConstruct
    public void init() {
        productoSku = new ProductoSku();
        listaProductoSku = productoSkuServicio.obtenerTodos();
    }
    
    public String editar(){
        setParamInFlashContext(PRODUCTO_SKU, productoSku);
        return "/pages/stock/productoPrecioForm?faces-redirect=true";
    }

  
    public List<ProductoSku> getListaProductoSku() {
        return listaProductoSku;
    }

    public void setListaProductoSku(List<ProductoSku> listaProductoSku) {
        this.listaProductoSku = listaProductoSku;
    }

    public ProductoSku getProductoSku() {
        return productoSku;
    }

    public void setProductoSku(ProductoSku productoSku) {
        this.productoSku = productoSku;
    }
    
    
}
