/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.cibertec.web.view.configuracion;

import javax.faces.context.Flash;






public class GenericController extends GenericMessageFactoryBean {
	
   
    
      protected static final String PRODUCTO = "PRODUCTO";
      protected static final String PRODUCTO_SKU = "PRODUCTO_SKU";
      protected static final String PROVEEDOR="PROVEEDOR";
      protected static final String COMPRA="COMPRA";
      protected static final String VENTA="VENTA";
      protected static final String DETALLE_COMPRA="DETALLE_COMPRA";
      protected static final String DETALLE_VENTA="DETALLE_VENTA";
      
    

    
    protected void setParamInFlashContext(String nameParam, Object valueParam){
		Flash flash = getFacesContext().getExternalContext().getFlash();
        flash.put(nameParam, valueParam);
    }

    protected Object getParamInFlashContext(String nameParam){
    	Flash flash = getFacesContext().getExternalContext().getFlash();
		return flash.get(nameParam);
     }

}
