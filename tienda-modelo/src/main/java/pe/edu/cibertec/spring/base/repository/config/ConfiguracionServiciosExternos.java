package pe.edu.cibertec.spring.base.repository.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:config-servicios-externos.properties")
public class ConfiguracionServiciosExternos {
    
    @Value("${externo.https.controlcomida}")
    private String controlComidaUrlBase;
}
