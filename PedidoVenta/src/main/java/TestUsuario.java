import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.joedayz.modelo.Cliente;
import com.joedayz.modelo.Grupo;
import com.joedayz.modelo.TipoPersona;
import com.joedayz.modelo.Usuario;


public class TestUsuario {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PedidoPU");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction trx = manager.getTransaction();
		trx.begin();

		Usuario usuario = new Usuario();
		usuario.setNombreUsuario("Juan Perez");
		usuario.setEmail("juan.perez@joedayz.pe");
		usuario.setPassword("123");

		Grupo grupo = new Grupo();
		grupo.setNombreGrupo("Vendedores");
		grupo.setDescripcion("Vendedores de la empresa");
		usuario.getGrupos().add(grupo);

		manager.persist(usuario);

		trx.commit();
	}
}
