package pe.edu.cibertec.spring.base.service.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FabricaConfiguracionServicio {

    /**
     * La anotación @Configuration sirve para indicar que la clase es una fábrica.
     * La anotación @Bean sirve para indicar que el método va a crear un bean de Spring.
     * El bean a crear va a ser obtenible por el Application Context (ctx)
     * usando ctx.getBean(ObjectMapper.class).
     * El id del bean, por defecto, será el nonmbre del método, en este caso,
     * objectMapper.
     * Se puede cambiar el id usando el atributo <code>name</code> de la
     * anotación @Bean ejm: <pre>@Bean(name="objMapper")</pre>
     * 
     * @return
     */
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
