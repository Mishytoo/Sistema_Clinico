package com.barrientos.sistema_clinico.controller;

import com.barrientos.sistema_clinico.entity.Persona;
import com.barrientos.sistema_clinico.service.IPersonaService;
import com.barrientos.sistema_clinico.util.paginator.PageRender;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
@RequestMapping("/persona")
@SessionAttributes("persona")
public class PersonaController {

    @Autowired
    //@Qualifier //seleccionar el bean concreto
    //private IPersonaDao personaDao;
    private IPersonaService personaService;

    //@PreAuthorize("hasRole('ENFERMERIA')")
    @RequestMapping(value = "/listarPer", method = RequestMethod.GET)
    public String listarPersonas(@RequestParam(name = "page", defaultValue = "0") int page, Model model){

        Pageable pageRequest = PageRequest.of(page, 5);
        Page<Persona> personas = personaService.findAll(pageRequest);

        PageRender<Persona> pageRender = new PageRender<>("/persona/listarPer", personas);

        model.addAttribute("titulo","Listado de Personas");
        model.addAttribute("personas", personas);
        model.addAttribute("page", pageRender);
        return "listar_persona";
    }

    @RequestMapping(value = "/formPer")
    public String formulario(Map<String, Object> model){ //VISTA
        Persona p = new Persona();

        model.put("titulo", "Formulario de Persona");
        model.put("persona", p);
        return "formulario_persona";
    }

    @RequestMapping(value = "/updPer/{id}")
    public String editar(@PathVariable (value = "id") Long id, Map<String, Object> model, RedirectAttributes flash){
        Persona persona = null;
        if( id > 0 ){
            persona = personaService.findOne(id);
            if (persona == null){
                flash.addFlashAttribute("error","Error en el proceso de modificacion: 0xE01.");
                return "redirect:/persona/listarPer";
            }
        }else{
            flash.addFlashAttribute("error","Error en el proceso de modificacion: 0xE00.");
            return "redirect:/persona/listarPer";
        }

        model.put("persona",persona);
        model.put("titulo","Editar Persona");
        return "formulario_persona";
    }

    @RequestMapping(value = "/regPer", method = RequestMethod.POST)
    public String guardar(@Valid Persona persona, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status){
        if(result.hasErrors()){
            model.addAttribute("titulo","Formulario de Persona");
            return "formulario_persona";
        }
        String messageFlash = (persona.getId() !=null) ? "Persona editada con exito!" : "Persona creada con exito!";
        personaService.save(persona);
        status.setComplete();
        flash.addFlashAttribute("success",messageFlash);
        return "redirect:listarPer";
    }

    @RequestMapping(value = "/delPer/{id}")
    public String eliminar (@PathVariable(value = "id") Long id, RedirectAttributes flash){
        if(id > 0){

            personaService.delete(id);
            flash.addFlashAttribute("success","Persona eliminada con exito!");
        }
        return "redirect:/persona/listarPer";

    }

}
