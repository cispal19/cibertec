package pe.edu.cibertec.spring.base;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import pe.edu.cibertec.spring.base.dominio.ProductoSku;
import pe.edu.cibertec.spring.base.dominio.Proveedor;
import pe.edu.cibertec.spring.base.service.ProductoSkuServicio;
import pe.edu.cibertec.spring.base.service.ProveedorServicio;

@ComponentScan(basePackages = "pe.edu.cibertec.spring.base")
//Si no se agrega la anotación @EnableAspectJAutoProxy
//no se podrán usar los aspectos en la aplicación
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class PrincipalSpringAnotacion {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(
                PrincipalSpringAnotacion.class)) {

            ProveedorServicio proveedorServicio=ctx.getBean(ProveedorServicio.class);
            Proveedor  proveedor = new Proveedor();
            proveedor.setNombre("CISPALSYSTEM SAC");
            proveedor.setNrodocumento("20602115161");
            
            proveedorServicio.guardar(proveedor);
            
        }
    }
}
