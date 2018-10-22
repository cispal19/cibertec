/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.spring.base.dominio;

import javax.persistence.Entity;
import javax.persistence.Table;
import pe.edu.cibertec.spring.base.dominio.base.Entidad;

/**
 *
 * @author julio
 */
@Entity
@Table(name = "proveedor")
public class Proveedor extends Entidad{
    
    
    private String nombre;
    private String nrodocumento;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNrodocumento() {
        return nrodocumento;
    }

    public void setNrodocumento(String nrodocumento) {
        this.nrodocumento = nrodocumento;
    }
    
    
    
    
}
