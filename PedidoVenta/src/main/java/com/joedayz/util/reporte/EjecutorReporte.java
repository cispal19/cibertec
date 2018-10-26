package com.joedayz.util.reporte;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;

import org.hibernate.jdbc.Work;

public class EjecutorReporte implements Work{

	private String rutaReporte;
	private HttpServletResponse response;
	private Map<String, Object> parametros;
	private String nombreReporteGenerado;

	private boolean reporteGenerado;
	
	
	
	public EjecutorReporte(String rutaReporte, HttpServletResponse response,
			Map<String, Object> parametros, String nombreReporteGenerado) {
		super();
		this.rutaReporte = rutaReporte;
		this.response = response;
		this.parametros = parametros;
		this.nombreReporteGenerado = nombreReporteGenerado;
		this.parametros.put(JRParameter.REPORT_LOCALE, new Locale("es", "PE"));
	}



	public void execute(Connection connection) throws SQLException {
		try {
			InputStream relatorioStream = this.getClass().getResourceAsStream(this.rutaReporte);

			JasperPrint print = JasperFillManager.fillReport(relatorioStream, this.parametros, connection);
			this.reporteGenerado = print.getPages().size() > 0;

			if (this.reporteGenerado) {
				JRExporter exportador = new JRPdfExporter();
				exportador.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
				exportador.setParameter(JRExporterParameter.JASPER_PRINT, print);

				response.setContentType("application/pdf");
				response.setHeader("Content-Disposition", "attachment; filename=\"" + this.nombreReporteGenerado  + "\"");

				exportador.exportReport();
			}
		} catch (Exception e) {
			throw new SQLException("Error al generar el reporte " + this.rutaReporte, e);
		}
	}

	public boolean isReporteGenerado() {
		return reporteGenerado;
	}

}
