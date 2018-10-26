import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.joedayz.modelo.Categoria;
import com.joedayz.modelo.Cliente;
import com.joedayz.modelo.DireccionEntrega;
import com.joedayz.modelo.EstadoPedido;
import com.joedayz.modelo.FormaPago;
import com.joedayz.modelo.ItemProducto;
import com.joedayz.modelo.Pedido;
import com.joedayz.modelo.Producto;
import com.joedayz.modelo.Usuario;


public class TestPedido {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PedidoPU");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction trx = manager.getTransaction();
		trx.begin();

		//Primero Buscamos
		Cliente cliente = manager.find(Cliente.class, 1L);
		Producto producto = manager.find(Producto.class, 1L);
		Usuario vendedor = manager.find(Usuario.class, 1L);

		DireccionEntrega direccionEntrega = new DireccionEntrega();
		direccionEntrega.setCiudad("Lima");
		direccionEntrega.setDistrito("Jesus Maria");
		direccionEntrega.setDireccionEntrega("Huamachuco");
		direccionEntrega.setReferencia("a espaldas de iglesia san jose");
		direccionEntrega.setNumeroContacto("5555555");
		
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setFechaPedido(new Date());
		pedido.setFechaEntrega(new Date());
		pedido.setFormaPago(FormaPago.CARTA_CREDITO);
		pedido.setObservacion("Abierto las 24h");
		pedido.setEstadoPedido(EstadoPedido.PRESUPUESTADO);
		pedido.setValorDescuento(BigDecimal.ZERO);
		pedido.setValorTransporte(BigDecimal.ZERO);
		pedido.setValorTotal(new BigDecimal(23.2));
		pedido.setVendedor(vendedor);
		pedido.setDireccionEntrega(direccionEntrega);
		
		ItemProducto item = new ItemProducto();
		item.setProducto(producto);
		item.setCantidad(10);
		item.setValorUnitario(new BigDecimal(2.32));
		item.setPedido(pedido);
		pedido.getItens().add(item);
		
		manager.persist(pedido);

		trx.commit();
		
	}
	
}
