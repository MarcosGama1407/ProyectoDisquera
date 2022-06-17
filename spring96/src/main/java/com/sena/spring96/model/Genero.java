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
@Table(name="generos")
public class Genero {

        //Atributos
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id_genero;
        @NotEmpty
        @Size(min=2,max=50)
        @Column(length = 50,nullable=false)
        private String nombre_genero;

        private boolean estado_genero;
    
        //Metodo constructor vacio
        public Genero(){
    
        }
    
        //Metodo constructor
        public Genero(Integer id_genero, String nombre_genero, boolean estado_genero){
            this.id_genero = id_genero;
            this.nombre_genero = nombre_genero;
            this.estado_genero = estado_genero;
        }
    
        //Accesores -> Para acceder a los atributos
        //Id Genero
        public Integer getIdGenero() {
            return id_genero; //Con retorno
        }
        public void setIdGenero(Integer id_genero) {
            this.id_genero = id_genero; //Sin retorno
        }
    
        //Nombre Genero
        public String getNombreGenero() {
            return nombre_genero;
        }
        public void setNombreGenero(String nombre_genero) {
            this.nombre_genero = nombre_genero;
        }
    
        //Estado Genero
        public boolean getEstadoGenero() {
            return estado_genero;
        }
        public void setEstadoGenero(boolean estado_genero) {
            this.estado_genero = estado_genero;
        }
}
