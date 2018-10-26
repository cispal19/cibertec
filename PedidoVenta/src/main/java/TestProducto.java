import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.joedayz.modelo.Categoria;
import com.joedayz.modelo.Cliente;
import com.joedayz.modelo.Grupo;
import com.joedayz.modelo.Producto;
import com.joedayz.modelo.TipoPersona;
import com.joedayz.modelo.Usuario;


public class TestProducto {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PedidoPU");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction trx = manager.getTransaction();
		trx.begin();

		// instanciamos la categoria padre (Bebidas)
		Categoria categoriaPadre = new Categoria();
		categoriaPadre.setDescripcion("Bebidas");

		// instanciamos la categoria hija (Refrigerantes)
		Categoria categoriaHija = new Categoria();
		categoriaHija.setDescripcion("Refrigerantes");
		categoriaHija.setCategoriaPadre(categoriaPadre);

		// adicionamos la categoria Refrigerantes como hija de Bebidas
		categoriaPadre.getSubcategorias().add(categoriaHija);

		manager.persist(categoriaPadre);

		// instanciamos un producto
		Producto produto = new Producto();
		produto.setCategoria(categoriaHija);
		produto.setNombreProducto("Guarana 1L");
		produto.setStock(10);
		produto.setSku("GU000123");
		produto.setValorUnitario(new BigDecimal(2.21));

		manager.persist(produto);

		trx.commit();
	}
}
