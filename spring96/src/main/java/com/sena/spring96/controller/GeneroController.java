package com.sena.spring96.controller;

import javax.validation.Valid;

import com.sena.spring96.model.Genero;
import com.sena.spring96.service.IGeneroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


@Controller
@SessionAttributes("genero")
@RequestMapping(value="/Genero")
public class GeneroController {
    @Autowired
    private IGeneroService generod;
    
    @GetMapping(value="/listgenero")//Generar la URL y cargar el index
    public String listgenero(Model m){

        m.addAttribute("generos", generod.findAll());
        return "genero/listgenero";
    }

    /*@GetMapping("/verc")
    public String verc(Model m){
        Genero gen=new Genero();
        gen.setIdGenero(1);
        gen.setNombreGenero("Marcos");
        gen.setEstadoGenero(false); 
        m.addAttribute("genero", gen);
        return "Genero/vercgenero";
    }*/

    @GetMapping("/ver/{id_genero}")
    public String ver(@PathVariable Integer id_genero,Model m){
    Genero genero=null;
    if(id_genero>0){
        genero=generod.findOne(id_genero);
    }else{
        return "redirect:listgenero";
    }
    m.addAttribute("genero",genero);
    m.addAttribute("accion", "Actualizar Genero");
    return "genero/addgenero";
    }

    @GetMapping("/form")
    public String form(Model m){
    Genero genero=new Genero();
    m.addAttribute("genero", genero);
    m.addAttribute("accion", "Agregar Genero");
    return "genero/addgenero";
    }
    
    @PostMapping(value="/addgenero")//Generar la URL y cargar el index
    public String addgenero(@Valid Genero genero,BindingResult res, Model m, SessionStatus status){
        if(res.hasErrors()){
            return "genero/addgenero";
            }
            generod.save(genero);
            status.setComplete();
            return "redirect:listgenero";
    }

    @GetMapping("/delete/{id_genero}")
    public String delete(@PathVariable Integer id_genero){

    if(id_genero>0){
        generod.delete(id_genero);
    }
    return "redirect:../listgenero";
    }
}
