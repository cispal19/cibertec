package pe.edu.cibertec.spring.base.aspecto;

import java.util.concurrent.TimeUnit;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.spring.base.aspecto.anotacion.LogMetodo;
import pe.edu.cibertec.spring.base.aspecto.anotacion.LogTiempoEjecucion;
//import pe.edu.cibertec.spring.base.service.ServicioInloggeable;
//import pe.edu.cibertec.spring.base.service.impl.ServicioInloggeableImpl;

@Aspect
@Component
public class LoggerAspecto {

    //Advice @Before: antes de ejecutar el método
    //@Before value: PointCut, es decir, los métodos afectados
    //JoinPoint jp: permite obtener meta datos del método en ejecución
//    @Before(value = "execution(* pe.edu.cibertec.spring.base.service.*.*(..))")
    public void loggearLlamadasAMetodos(JoinPoint jp) {
//        if (jp.getTarget().getClass().equals(ServicioInloggeableImpl.class)) {
//            return;
//        }
        System.out.println("------------------------------------------");
        System.out.println("Aspecto por método. Método en ejecución" +
                jp.getSignature().toLongString());
        int contador = 1;
        for (Object parametro : jp.getArgs()) {
            System.out.println(String.format("Argumento %d: %s",
                    contador++, parametro));
        }
        System.out.println("------------------------------------------");
    }

    /*
    El PointCut para las anotaciones es @annotation(<nombre de variable de anotación>)
    el cual DEBE SER IGUAL al nombre de la variable cuyo tipo es nuestra anotación
    */
    @Before(value = "execution(* pe.edu.cibertec.spring.base.service.*.*(..))"
            + " && @annotation(logMetodo)")
    public void loggearLlamadasAMetodos(JoinPoint jp,
            //Aquí va nuestra @interface SIN el @.
            LogMetodo logMetodo) {
        System.out.println("------------------------------------------");
        System.out.println("Aspecto por anotación. Método en ejecución" +
                jp.getSignature().toLongString());
        if (logMetodo.imprimirArgumentos()) {
            int contador = 1;
            for (Object parametro : jp.getArgs()) {
                System.out.println(String.format("Argumento %d: %s",
                        contador++, parametro));
            }
        }
        System.out.println("------------------------------------------");
    }

    /*
    Cuando usamos @Around, la interfaz JoinPoint se queda corta de métodos para
    conocer si el método real terminó su ejecución. Esta deberá ser reemplazada
    por ProceedingJoinPoint.
    */
    @Around(value = "@annotation(logTiempoEjecucion)")
    public Object loggearTiempoEjecucion(ProceedingJoinPoint pjp,
            //Aquí va nuestra @interface SIN el @.
            LogTiempoEjecucion logTiempoEjecucion) throws Throwable {
        long inicio = System.nanoTime();
        try {
            return pjp.proceed();
        } finally {
            long fin = System.nanoTime();
            long tiempoTotal = fin - inicio;
            System.out.println(String.format(
                    "Método %s. Tiempo de ejecución: %d micro seconds.", pjp.getSignature(),
                    TimeUnit.NANOSECONDS.toMicros(tiempoTotal)));
        }
    }
}
