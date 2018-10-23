/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.web.view.bean.producto;

import java.lang.annotation.Annotation;
import javax.annotation.PostConstruct;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.spring.base.dominio.Producto;
import pe.edu.cibertec.spring.base.service.ProductoServicio;
import pe.edu.cibertec.spring.base.service.impl.ProductoServiceImpl;

/**
 *
 * @author JCISNEROSP
 */
@Component("productoConverter")
public class ProductoConverter implements Converter {
    
    @Autowired
    private ProductoServicio productoServicio;
     

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        Producto retorno = null;

        if (value != null && !"".equals(value)) {
            retorno = productoServicio.obtenerPorId(Integer.parseInt(value));
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value != null) {
            Producto producto = (Producto) value;
            return producto.getId() == null ? null : producto.getId().toString();
        }

        return "";
    }

   

}
