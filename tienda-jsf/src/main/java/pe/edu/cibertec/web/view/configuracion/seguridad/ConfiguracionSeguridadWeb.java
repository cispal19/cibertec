/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.web.view.configuracion.seguridad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 *
 * @author JAdv-MJ
 */
@Configuration
@EnableWebSecurity
public class ConfiguracionSeguridadWeb extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.csrf().disable()//solo por motivo de prueba en produccion siempre debe de estar habilitado
       .authorizeRequests()
               .antMatchers("/","/productos.xhtml","/pages/producto/productoForm.xhtml",
                       "/pages/producto/productos.xhtml",
                       "/pages/stock/productoPrecio.xhtml",
                       "/pages/stock/productoPrecioForm.xhtml")
               .permitAll()
               .anyRequest().authenticated()
               .and()
               .formLogin()
               .loginPage("/login3.xhtml")
               .loginProcessingUrl("/login3")
               .usernameParameter("correoElectronico")
               .passwordParameter("contrasena")
               .defaultSuccessUrl("/principal.xhtml")
               .failureUrl("/login3.xhtml?error=true")
               .permitAll();
    }
    
    
  @Bean  
  @Override
  public UserDetailsService userDetailsService(){
      UserDetails user = User.withDefaultPasswordEncoder()
              .username("julio")
              .password("123")
              .roles("USUARIO")
              .build();
      return new InMemoryUserDetailsManager(user);
  
  }
    
    
    
}
