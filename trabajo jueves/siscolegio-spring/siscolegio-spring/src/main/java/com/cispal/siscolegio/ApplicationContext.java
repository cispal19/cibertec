/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cispal.siscolegio;

import com.cispal.siscolegio.domain.Alumno;
import com.cispal.siscolegio.domain.Persona;
import com.cispal.siscolegio.service.AlumnoService;
import com.cispal.siscolegio.service.OtraPersonaService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 *
 * @author JCISNEROSP
 */
@ComponentScan(basePackages = "com.cispal.siscolegio")
@EnableTransactionManagement
public class ApplicationContext {
    
          public static void main(String[] args) {
        try (AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(
                ApplicationContext.class)) {

//            OtraPersonaService ops = ctx.getBean(OtraPersonaService.class);
//            Persona px = new Persona();
//            px.setDni("777777");
//            px.setNombre("Luiggi");
//            px.setEdad(60);
//            ops.guardar(px);
            
              AlumnoService alumnoService = ctx.getBean(AlumnoService.class);
            Alumno alumno = new Alumno();
//            alumno.setIdalumno(1);
            alumno.setNombres("julio cesar");
            alumno.setApellidos("cisneros palomino");
            alumno.setDireccion("callao");
            alumno.setEmail("cispal19@gmail.com");
            alumno.setSeccion("a");
            alumno.setTelefono("123456789");
            alumno.setSexo("M");
            alumno.setGrado("primero");
            
           
            alumnoService.guardar(alumno);
        }
    }
    }
    

