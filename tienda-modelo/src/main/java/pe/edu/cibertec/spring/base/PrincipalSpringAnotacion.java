package pe.edu.cibertec.spring.base;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import pe.edu.cibertec.spring.base.dominio.Categoria;
import pe.edu.cibertec.spring.base.dominio.Producto;

import pe.edu.cibertec.spring.base.service.ProductoServicio;

import pe.edu.cibertec.spring.base.dominio.Proveedor;

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


//            ProductoSkuServicio pss = ctx.getBean(ProductoSkuServicio.class);
//            ProductoSku ps = pss.obtenerPorId(4);
//            System.out.printf("%d %d %s %d %s\n", ps.getId(),
//                    ps.getProducto().getId(),
//                    ps.getProducto().getNombre(),
//                    ps.getProducto().getCategoria().getId(),
//                    ps.getProducto().getCategoria().getNombre());
            
//            ProductoServicio pss = ctx.getBean(ProductoServicio.class);
//            Producto producto= new Producto();
//            Categoria categoria = new Categoria();
//            categoria.setId(1);
//            producto.setNombre("sin anotacion");
//            producto.setDescripcion("sin anotacion");
//            producto.setCategoria(categoria);
//            pss.guardar(producto);
            

            ProveedorServicio proveedorServicio=ctx.getBean(ProveedorServicio.class);
            Proveedor  proveedor = new Proveedor();
            proveedor.setNombre("CISPALSYSTEM SAC");
            proveedor.setNrodocumento("20602115161");
            
            proveedorServicio.guardar(proveedor);

            
        }
    }
}
