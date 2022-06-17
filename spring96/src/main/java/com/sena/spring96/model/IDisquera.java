package com.sena.spring96.model;

import java.util.List;

public interface IDisquera {
    
    public List<Disquera> findAll();
    public void save(Disquera disquera);
    public Disquera findOne(Integer id_disquera);
    public void delete(Integer id_disquera);

}
