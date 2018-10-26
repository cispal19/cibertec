package com.joedayz.controller;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

import com.joedayz.modelo.Usuario;
import com.joedayz.repositorio.PedidoRepositorio;
import com.joedayz.security.UsuarioLogeado;
import com.joedayz.security.UsuarioSistema;

@Named
@RequestScoped
public class GraficosPedidosCreadosBean {

	private static DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM");
	
	@Inject private PedidoRepositorio pedidoRepositorio;
	@Inject @UsuarioLogeado 
	private UsuarioSistema usuarioSistema;
	
	private CartesianChartModel model;

	public void preRender(){
		this.model = new CartesianChartModel();
		adicionarSerie("Todos los pedidos", null);
		adicionarSerie("Mis pedidos", usuarioSistema.getUsuario());
	}
	
	private void adicionarSerie(String etiqueta, Usuario usuarioCreador) {
		Map<Date, BigDecimal> valoresPorFecha = this.pedidoRepositorio.valoresTotalesFecha(15, usuarioCreador);
		
		ChartSeries series = new ChartSeries(etiqueta);
		
		for (Date fecha : valoresPorFecha.keySet()) {
			series.set(DATE_FORMAT.format(fecha), valoresPorFecha.get(fecha));
		}
		
		this.model.addSeries(series);
	}

	public CartesianChartModel getModel() {
		return model;
	}
	
	
}
