package com.joedayz.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

import org.hibernate.Session;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

import com.joedayz.util.FacesUtil;
import com.joedayz.util.reporte.EjecutorReporte;

@Named
@RequestScoped
public class ReportePedidosEmitidosBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Date fechaInicio;
	private Date fechaFin;
	
	@Inject private FacesContext facesContext;
	@Inject private HttpServletResponse response;
	@Inject private EntityManager entityManager;
	

	public void emitir() {
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("fecha_inicio", this.fechaInicio);
		parametros.put("fecha_fin", this.fechaFin);

		EjecutorReporte executor = new EjecutorReporte("/reportes/reporte_pedidos_emitidos.jasper",
				this.response, parametros, "Pedidos emitidos.pdf");

		Session session = entityManager.unwrap(Session.class);
		session.doWork(executor);

		if (executor.isReporteGenerado()) {
			facesContext.responseComplete();
		} else {
			FacesUtil.adicionarMensajeError("No hay datos para el rango de fechas escogida..");
		}
	}
	
	@NotNull
	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	@NotNull
	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	
}
