package pe.edu.cibertec.spring.base.repository.impl.util;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.util.CollectionUtils;

public class JpaQueryUtil {

    public static <T> T obtenerUnicoResultado(TypedQuery<T> query) {
        List<T> resultados = query.getResultList();
        return CollectionUtils.isEmpty(resultados) ? null : resultados.get(0);
    }
}
