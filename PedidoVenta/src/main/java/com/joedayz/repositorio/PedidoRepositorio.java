package com.joedayz.repositorio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;

import com.joedayz.modelo.FechaValor;
import com.joedayz.modelo.Pedido;
import com.joedayz.modelo.Usuario;
import com.joedayz.repositorio.filtros.PedidoFiltros;

public class PedidoRepositorio implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;
	

	@SuppressWarnings("unchecked")
	public List<Pedido> listarPedidosFiltrados(PedidoFiltros filtro) {
		Session session = this.entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Pedido.class).createAlias("cliente", "c").createAlias("vendedor", "v");

		if (filtro.getNumeroInicial() != null) {
			criteria.add(Restrictions.ge("idPedido", filtro.getNumeroInicial()));
		}

		if (filtro.getNumeroFinal() != null) {
			criteria.add(Restrictions.le("idPedido", filtro.getNumeroFinal()));
		}

		if (filtro.getFechaInicial() != null) {
			criteria.add(Restrictions.ge("fechaPedido", filtro.getFechaInicial()));
		}

		if (filtro.getFechaFinal() != null) {
			criteria.add(Restrictions.le("fechaPedido", filtro.getFechaFinal()));
		}

		if (StringUtils.isNotBlank(filtro.getNombreCliente())) {
			criteria.add(Restrictions.ilike("c.nombreCliente", filtro.getNombreCliente(), MatchMode.ANYWHERE));
		}

		if (StringUtils.isNotBlank(filtro.getNombreVendedor())) {
			criteria.add(Restrictions.ilike("v.nombreUsuario", filtro.getNombreVendedor(), MatchMode.ANYWHERE));
		}

		if (filtro.getEstadoPedidos() != null && filtro.getEstadoPedidos().length > 0) {
			criteria.add(Restrictions.in("estadoPedido", filtro.getEstadoPedidos()));
		}

		return criteria.addOrder(Order.asc("idPedido")).list();
	}


	public Pedido adicionarPedido(Pedido pedido) {
		return this.entityManager.merge(pedido);
	}

	public Pedido obtenerPedido(Long id){
		return entityManager.find(Pedido.class, id);
	}
	
	
	@SuppressWarnings("unchecked")
	public Map<Date, BigDecimal> valoresTotalesFecha(Integer numeroDias, Usuario usuarioCreador){
		Session session = entityManager.unwrap(Session.class);
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

	private Map<Date, BigDecimal> crearMapaInicial(Integer numeroDias, Calendar fechaActual) {

		fechaActual = (Calendar) fechaActual.clone();
		Map<Date, BigDecimal> mapaInicial = new TreeMap<Date, BigDecimal>();
		
		for(int i=0;i<=numeroDias;i++){
			mapaInicial.put(fechaActual.getTime(), BigDecimal.ZERO);
			fechaActual.add(Calendar.DAY_OF_MONTH, 1);
		}
		
		return mapaInicial;
	}
	
}
