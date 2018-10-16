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
      
    

    
    protected void setParamInFlashContext(String nameParam, Object valueParam){
		Flash flash = getFacesContext().getExternalContext().getFlash();
        flash.put(nameParam, valueParam);
    }

    protected Object getParamInFlashContext(String nameParam){
    	Flash flash = getFacesContext().getExternalContext().getFlash();
		return flash.get(nameParam);
     }

}
