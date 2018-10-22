/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.spring.base.repository.impl;


import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.spring.base.dominio.Proveedor;
import pe.edu.cibertec.spring.base.repository.ProveedorRepositorio;

/**
 *
 * @author julio
 */
@Repository
public class ProveedorRepositorioJpaImpl extends RepositorioBaseJpaImpl<Proveedor> implements ProveedorRepositorio{

    @Override
    public Proveedor getProveedorByRuc(String ruc) {
        Session session =(Session) em.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Proveedor.class);
        if (StringUtils.isNotBlank(ruc)) {
            criteria.add(Restrictions.eq("nrodocumento", ruc));
        }
        
        Proveedor pro =(Proveedor) criteria.uniqueResult();
        return pro;
        
    }
    
}
