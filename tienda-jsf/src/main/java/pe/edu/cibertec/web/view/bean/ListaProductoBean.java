package pe.edu.cibertec.web.view.bean;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pe.edu.cibertec.spring.base.dominio.ProductoSku;
import pe.edu.cibertec.spring.base.service.ProductoSkuServicio;

@Component //@ManagedBean
@Scope("view") //@ViewScoped
public class ListaProductoBean {

    private List<ProductoSku> listaProductoSku;

    @Autowired
    private ProductoSkuServicio productoSkuServicio;

    @PostConstruct
    public void init() {
        listaProductoSku = productoSkuServicio.obtenerTodos();
    }

    public List<ProductoSku> getListaProductoSku() {
        return listaProductoSku;
    }

    public void setListaProductoSku(List<ProductoSku> listaProductoSku) {
        this.listaProductoSku = listaProductoSku;
    }
}
