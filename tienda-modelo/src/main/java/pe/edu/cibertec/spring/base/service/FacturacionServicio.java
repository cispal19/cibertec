package pe.edu.cibertec.spring.base.service;

import java.util.List;
import pe.edu.cibertec.spring.base.dominio.Producto;
import pe.edu.cibertec.spring.base.dominio.Usuario;
import pe.edu.cibertec.spring.base.dominio.Venta;

public interface FacturacionServicio {

    /**
     * Crea un registro de venta para un usuario y una lista de productos
     * que ha seleccionado.
     * @param usuario El cliente que ejecuta la compra
     * @param listaProducto Lista de productos seleccionados
     * @return Venta generada para el usuario y sus productos
     */
    Venta generarVenta(Usuario usuario, List<Producto> listaProducto);

}
