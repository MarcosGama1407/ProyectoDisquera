package com.sena.spring96.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="albums")
public class Album {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_album;
    @NotEmpty
    @Size(min=2,max=50)
    @Column(length = 50,nullable=false)
    private String nombre_album;

    private String publicacion_album;

    private boolean estado_album;

    //Metodo constructor vacio
    public Album(){
    
    }

    //Metodo constructor
    public Album(Integer id_album, String nombre_album, String publicacion_album, boolean estado_album){
        this.id_album = id_album;
        this.nombre_album = nombre_album;
        this.publicacion_album = publicacion_album;
        this.estado_album = estado_album;
    }

    public Integer getId_album() {
        return id_album;
    }

    public void setId_album(Integer id_album) {
        this.id_album = id_album;
    }

    public String getNombre_album() {
        return nombre_album;
    }

    public void setNombre_album(String nombre_album) {
        this.nombre_album = nombre_album;
    }

    public String getPublicacion_album() {
        return publicacion_album;
    }

    public void setPublicacion_album(String publicacion_album) {
        this.publicacion_album = publicacion_album;
    }

    public boolean isEstado_album() {
        return estado_album;
    }

    public void setEstado_album(boolean estado_album) {
        this.estado_album = estado_album;
    }


     //Accesores -> Para acceder a los atributos
        //
        //album
      

}
