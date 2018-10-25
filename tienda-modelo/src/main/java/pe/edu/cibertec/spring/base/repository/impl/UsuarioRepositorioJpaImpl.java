package pe.edu.cibertec.spring.base.repository.impl;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.spring.base.dominio.Usuario;
import pe.edu.cibertec.spring.base.repository.UsuarioRepositorio;

@Repository
public class UsuarioRepositorioJpaImpl
    extends RepositorioBaseJpaImpl<Usuario>
        implements UsuarioRepositorio {
    

    @Override
    public Usuario login(String usuario, String contrasena) {
       
        Session session = (Session) em.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Usuario.class);

        if (StringUtils.isNotBlank(usuario)) {
            criteria.add(Restrictions.eq("nombre", usuario));
//            criteria.add(Restrictions.eq("contrasena",contrasena));
        }

        Usuario usuarioObtenido = (Usuario) criteria.uniqueResult();

        if (usuarioObtenido == null) {
            usuarioObtenido = new Usuario();
        }

        return usuarioObtenido;
    }
    
}
