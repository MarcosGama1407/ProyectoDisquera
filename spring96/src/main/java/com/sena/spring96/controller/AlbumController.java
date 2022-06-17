package com.sena.spring96.controller;

import javax.validation.Valid;

import com.sena.spring96.model.Album;
import com.sena.spring96.model.IAlbum;

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
@SessionAttributes("album")
@RequestMapping(value="/Album")
public class AlbumController {
    @Autowired
    private IAlbum albumd;
    
    @GetMapping(value="/listalbum")//Generar la URL y cargar el index
    public String listalbum(Model m){

        m.addAttribute("albums", albumd.findAll());
        return "album/listalbum";
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

    @GetMapping("/ver/{id_album}")
    public String ver(@PathVariable Integer id_album,Model m){
    Album album=null;
    if(id_album>0){
        album=albumd.findOne(id_album);
    }else{
        return "redirect:listalbum";
    }
    m.addAttribute("album",album);
    m.addAttribute("accion", "Actualizar Album");
    return "album/addalbum";
    }

    @GetMapping("/form")
    public String form(Model m){
    Album album=new Album();
    m.addAttribute("album", album);
    m.addAttribute("accion", "Agregar Album");
    return "album/addalbum";
    }
    
    @PostMapping(value="/addalbum")//Generar la URL y cargar el index
    public String addalbum(@Valid Album album,BindingResult res, Model m, SessionStatus status){
        if(res.hasErrors()){
            return "album/addalbum";
            }
            albumd.save(album);
            status.setComplete();
            return "redirect:listalbum";
    }

    @GetMapping("/delete/{id_album}")
    public String delete(@PathVariable Integer id_album){

    if(id_album>0){
        albumd.delete(id_album);
    }
    return "redirect:../listalbum";
    }
}
