package com.barrientos.sistema_clinico.controller;

import com.barrientos.sistema_clinico.entity.Persona;
import com.barrientos.sistema_clinico.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    // la clase model se utiliza para transferir objetos del controller a la vista.
    public String listarPersonas(Model model)
    {
        List<Persona> personas = personaService.obtenerPersonas();
        model.addAttribute("listaPersonas", personas); // llave : valor
        return "listar";
    }

    @GetMapping("/formulario-persona")
    public String MostrarFormularioPersona(Model model)
    {
        model.addAttribute("persona", new Persona());
        // esto de acciona con el metodo post
        model.addAttribute("accion", "/personas/nueva");
        return "formulario";
    }


    @PostMapping("/nueva")
    public  String guardarPersona(@ModelAttribute Persona persona)
    {
        personaService.crearPersona(persona);
        return "redirect:/personas";
    }


    @GetMapping("/editar/{id}")
    public String MostrarFormularioEditarPersona(@PathVariable Long id, @ModelAttribute Persona persona, Model model)
    {
        model.addAttribute("persona", persona);
        // esto de acciona con el metodo post
        // "Editar"
        model.addAttribute("accion", "/personas/editar/"+id);
        return "formulario";
    }

    @PostMapping("/editar/{id}")
    public String actualizarPersona(@PathVariable Long id, @ModelAttribute Persona persona)
    {
        personaService.actualizarPersona(id, persona);
        return "redirect:/personas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPersona(@PathVariable Long id)
    {
        personaService.eliminarPersona(id);
        return "redirect:/personas";
    }
}
