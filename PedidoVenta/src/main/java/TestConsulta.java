import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.lang3.time.DateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;

import com.joedayz.modelo.FechaValor;
import com.joedayz.modelo.Pedido;
import com.joedayz.modelo.Usuario;


public class TestConsulta {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PedidoPU");
		EntityManager manager = factory.createEntityManager();
		Session session = manager.unwrap(Session.class);
		Usuario usuario = new Usuario();
		usuario.setIdeUsuario(1L);
		
//		Map<Date, BigDecimal> valores = valoresTotalesFecha(15, null, session);
		Map<Date, BigDecimal> valores = valoresTotalesFecha(15, usuario, session);
		
		for(Date fecha : valores.keySet()){
			System.out.println("la fecha: "+fecha + " = "+ valores.get(fecha));
		}
		
		manager.close();
	}
	
	@SuppressWarnings("unchecked")
	public static Map<Date, BigDecimal> valoresTotalesFecha(Integer numeroDias, Usuario usuarioCreador, 
												Session session){
		numeroDias -=1;
		Calendar fechaActual = Calendar.getInstance();
		fechaActual = DateUtils.truncate(fechaActual, Calendar.DAY_OF_MONTH);
		fechaActual.add(Calendar.DAY_OF_MONTH, numeroDias * -1);
		
		Map<Date, BigDecimal> resultado = crearMapaInicial(numeroDias, fechaActual);
		
		Criteria criteria = session.createCriteria(Pedido.class);
		criteria = criteria.setProjection(Projections.projectionList()
					.add(Projections.sqlGroupProjection("date(fecha_pedido) as fecha", 
														"date(fecha_pedido)", 
														new String[]{"fecha"}, 
														new Type[] {StandardBasicTypes.DATE}))
					.add(Projections.sum("valorTotal").as("valor"))
				)
				.add(Restrictions.ge("fechaPedido", fechaActual.getTime())); 
		
		if(usuarioCreador != null){
			criteria.add(Restrictions.eq("vendedor", usuarioCreador));
		}
		List<FechaValor> valoresFecha = criteria.setResultTransformer(Transformers.aliasToBean(FechaValor.class)).list();
		for(FechaValor fechaValor : valoresFecha){
			resultado.put(fechaValor.getFecha(), fechaValor.getValor());
		}
		return resultado;
	}

	private static Map<Date, BigDecimal> crearMapaInicial(Integer numeroDias,
			Calendar fechaActual) {

		fechaActual = (Calendar) fechaActual.clone();
		Map<Date, BigDecimal> mapaInicial = new TreeMap<Date, BigDecimal>();
		
		for(int i=0;i<=numeroDias;i++){
			mapaInicial.put(fechaActual.getTime(), BigDecimal.ZERO);
			fechaActual.add(Calendar.DAY_OF_MONTH, 1);
		}
		
		return mapaInicial;
	}
	
	
}
