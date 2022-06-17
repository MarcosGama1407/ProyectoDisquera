package com.sena.spring96.controller;

import javax.validation.Valid;

import com.sena.spring96.model.Disquera;
import com.sena.spring96.model.IDisquera;

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
@SessionAttributes("disquera")
@RequestMapping(value="/Disquera")
public class DisqueraController {
    @Autowired
    private IDisquera disquerad;
    
    @GetMapping(value="/listdisquera")//Generar la URL y cargar el index
    public String listdisquera(Model m){

        m.addAttribute("disqueras", disquerad.findAll());
        return "disquera/listdisquera";
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

    @GetMapping("/ver/{id_disquera}")
    public String ver(@PathVariable Integer id_disquera,Model m){
    Disquera disquera=null;
    if(id_disquera>0){
        disquera=disquerad.findOne(id_disquera);
    }else{
        return "redirect:listdisquera";
    }
    m.addAttribute("disquera",disquera);
    m.addAttribute("accion", "Actualizar Disquera");
    return "disquera/adddisquera";
    }

    @GetMapping("/form")
    public String form(Model m){
    Disquera disquera=new Disquera();
    m.addAttribute("disquera", disquera);
    m.addAttribute("accion", "Agregar Disquera");
    return "disquera/adddisquera";
    }
    
    @PostMapping(value="/adddisquera")//Generar la URL y cargar el index
    public String adddisquera(@Valid Disquera disquera,BindingResult res, Model m, SessionStatus status){
        if(res.hasErrors()){
            return "disquera/adddisquera";
            }
            disquerad.save(disquera);
            status.setComplete();
            return "redirect:listdisquera";
    }

    @GetMapping("/delete/{id_disquera}")
    public String delete(@PathVariable Integer id_disquera){

    if(id_disquera>0){
        disquerad.delete(id_disquera);
    }
    return "redirect:../listdisquera";
    }
}
