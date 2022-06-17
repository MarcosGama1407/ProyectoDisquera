package com.sena.spring96.service;

import java.util.List;

import com.sena.spring96.model.Genero;

public interface IGeneroService {
    
    public List<Genero> findAll();
    public void save(Genero genero);
    public Genero findOne(Integer id_genero);
    public void delete(Integer id_genero);
    
}
