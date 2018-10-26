import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.joedayz.modelo.Cliente;
import com.joedayz.modelo.Grupo;
import com.joedayz.modelo.TipoPersona;
import com.joedayz.modelo.Usuario;


public class TestCliente {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PedidoPU");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction trx = manager.getTransaction();
		trx.begin();

		Cliente cliente = new Cliente();
		cliente.setEmail("ierosas28@gmail.com");
		cliente.setNombreCliente("Israel Rosas");
		cliente.setNumeroDocumento("45103054");
		cliente.setTipo(TipoPersona.NATURAL);


		manager.persist(cliente);

		trx.commit();
	}
}
