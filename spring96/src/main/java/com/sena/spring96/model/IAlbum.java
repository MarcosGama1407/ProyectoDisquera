package com.sena.spring96.model;

import java.util.List;

public interface IAlbum {
    
    public List<Album> findAll();
    public void save(Album album);
    public Album findOne(Integer id_album);
    public void delete(Integer id_album);

}
