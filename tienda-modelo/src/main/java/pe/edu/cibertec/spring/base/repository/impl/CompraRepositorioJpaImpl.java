/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.spring.base.repository.impl;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.spring.base.dominio.Compra;
import pe.edu.cibertec.spring.base.repository.CompraRepositorio;

/**
 *
 * @author julio
 */
@Repository
public class CompraRepositorioJpaImpl extends
        RepositorioBaseJpaImpl<Compra> implements CompraRepositorio {

    @Override
    public List<Compra> listarCompra(Compra compra) {
        Session session = (Session) em.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Compra.class);
        List<Compra> lista=null;
        try {
            if (StringUtils.isNotBlank(compra.getDocumento())) {
                criteria.add(Restrictions.eq("documento", compra.getDocumento()));
                
            }
            lista=criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

}
