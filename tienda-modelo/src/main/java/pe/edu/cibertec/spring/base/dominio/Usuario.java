package pe.edu.cibertec.spring.base.dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import pe.edu.cibertec.spring.base.dominio.base.Entidad;

@Entity
@Table(name = "usuario")
public class Usuario extends Entidad  implements Serializable{

    @Column(name="correo_electronico")
    private String correoElectronico;
    private String contrasena;
    private String nombre;

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Usuario{" + "correoElectronico=" + correoElectronico + ", contrasena=" + contrasena + ", nombre=" + nombre + '}';
    }
    
    
}
