package pe.edu.cibertec.web.view.bean;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pe.edu.cibertec.spring.base.service.ProductoSkuServicio;

@Component
@Scope("request")
public class ProductoDetalleBean {

    private Integer idProducto;

    @Autowired
    private ProductoSkuServicio productoSkuServicio;

    @PostConstruct
    public void init() {
        
    }
}
