package com.sena.spring96.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class AlbumDao implements IAlbum{
    @PersistenceContext
    private EntityManager em;

    //Metodo de listar todo
    @Transactional(readOnly=true)
    @Override   //Sobreescritura para poderlo llamar varias veces
    public List<Album> findAll(){
        
        return em.createQuery("from Album").getResultList();

    }

    @Transactional
    @Override   //Sobreescritura para poderlo llamar varias veces
    public void save(Album album){
        
        if (album.getId_album() != null && album.getId_album() > 0) {
			em.merge(album);
		} else {
			em.persist(album);
		}

    }

    @Override
    @Transactional(readOnly = true)
    public Album findOne(Integer id_album) {
        
        return em.find(Album.class, id_album);
    }

    @Override
    @Transactional
    public void delete(Integer id_album) {
        em.remove(findOne(id_album));
    }  
}
