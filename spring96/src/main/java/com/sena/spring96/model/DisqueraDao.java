package com.sena.spring96.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class DisqueraDao implements IDisquera {
    @PersistenceContext
    private EntityManager em;

    //Metodo de listar todo
    @Transactional(readOnly=true)
    @Override   //Sobreescritura para poderlo llamar varias veces
    public List<Disquera> findAll(){
        
        return em.createQuery("from Disquera").getResultList();

    }

    @Transactional
    @Override   //Sobreescritura para poderlo llamar varias veces
    public void save(Disquera disquera){
        
        if (disquera.getIdDisquera() != null && disquera.getIdDisquera() > 0) {
			em.merge(disquera);
		} else {
			em.persist(disquera);
		}

    }

    @Override
    @Transactional(readOnly = true)
    public Disquera findOne(Integer id_disquera) {
        
        return em.find(Disquera.class, id_disquera);
    }

    @Override
    @Transactional
    public void delete(Integer id_disquera) {
        em.remove(findOne(id_disquera));
    }  
}
