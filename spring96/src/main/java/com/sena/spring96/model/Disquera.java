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
@Table(name="disqueras")
public class Disquera {
    
    //Atributos
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id_disquera;
        @Column(length=50, nullable=true)
        private Integer nit_disquera;
        @NotEmpty
        @Size(min=2,max=50)
        @Column(length = 50,nullable=false)
        private String nombre_disquera;
        @Column(length=50, nullable=true)
        private String telefono_disquera;

        private String direccion_disquera;

        private boolean estado_disquera;
    
        //Metodo constructor vacio
        public Disquera(){
    
        }
    
        //Metodo constructor
        public Disquera(Integer id_disquera, Integer nit_disquera, String nombre_disquera, String telefono_disquera, String direccion_disquera, boolean estado_disquera){
            this.id_disquera = id_disquera;
            this.nit_disquera = nit_disquera;
            this.nombre_disquera = nombre_disquera;
            this.telefono_disquera = telefono_disquera;
            this.direccion_disquera = direccion_disquera;
            this.estado_disquera = estado_disquera;
        }
    
        //Accesores -> Para acceder a los atributos
        //
        //Id Genero
        public Integer getIdDisquera() {
            return id_disquera; //Con retorno
        }
        public void setIdDisquera(Integer id_disquera) {
            this.id_disquera = id_disquera; //Sin retorno
        }
    
        //Nit Disquera
        public Integer getNitDisquera() {
            return nit_disquera; //Con retorno
        }
        public void setNitDisquera(Integer nit_disquera) {
            this.nit_disquera = nit_disquera; //Sin retorno
        }

        //Nombre Disquera
        public String getNombreDisquera() {
            return nombre_disquera;
        }
        public void setNombreDisquera(String nombre_disquera) {
            this.nombre_disquera = nombre_disquera;
        }

        //Telefono Disquera
        public String getTelefonoDisquera() {
            return telefono_disquera;
        }
        public void setTelefonoDisquera(String telefono_disquera) {
            this.telefono_disquera = telefono_disquera;
        }
    
        //Direccion Disquera
        public String getDireccionDisquera() {
            return direccion_disquera;
        }
        public void setDireccionDisquera(String direccion_disquera) {
            this.direccion_disquera = direccion_disquera;
        }

        //Estado Disquera
        public boolean getEstadoDisquera() {
            return estado_disquera;
        }
        public void setEstadoDisquera(boolean estado_disquera) {
            this.estado_disquera = estado_disquera;
        }
}