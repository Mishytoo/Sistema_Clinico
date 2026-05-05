package com.barrientos.sistema_clinico.controller;

import com.barrientos.sistema_clinico.entity.Persona;
import com.barrientos.sistema_clinico.entity.TipoUsuario;
import com.barrientos.sistema_clinico.entity.Usuario;
import com.barrientos.sistema_clinico.service.IPersonaService;
import com.barrientos.sistema_clinico.service.ITipoUsuarioService;
import com.barrientos.sistema_clinico.service.IUsuarioService;
import com.barrientos.sistema_clinico.util.paginator.PageRender;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("usuario")
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IPersonaService personaService;

    @Autowired
    private ITipoUsuarioService tipoUsuarioService;

    //@PreAuthorize("hasRole('ADMINISTRADOR')")
    @RequestMapping(value = "listarUsu", method = RequestMethod.GET)
    public String listarUsuarios(@RequestParam(name = "page", defaultValue = "0") int page, Model model){

        //List<Usuario> usuarios = usuarioService.findAll();
        Pageable pageRequest = PageRequest.of(page, 3);
        Page<Usuario> usuarios = usuarioService.findAll(pageRequest);
        PageRender<Usuario> pageRender = new PageRender<>("/usuario/listarUsu", usuarios);


        model.addAttribute("titulo","Listado de Usuarios");
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("page", pageRender);
        return "listar_usuario";
    }

    @RequestMapping(value = "/formUsu")
    public String formulario(Map<String, Object> model){ //VISTA
        Usuario usu = new Usuario();
        List<TipoUsuario> listaTipoUsuario = tipoUsuarioService.findAll();

        model.put("titulo", "Formulario de Usuario");
        model.put("usuario", usu);
        model.put("listaTipos", listaTipoUsuario);
        return "formulario_usuario";
    }

    @RequestMapping(value = "/regUsu", method = RequestMethod.POST)
    public String guardar(@Valid Usuario usuario, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status){
        if(result.hasErrors()){
            List<TipoUsuario> listaTipoUsuario = tipoUsuarioService.findAll();

            model.addAttribute("titulo","Formulario de Usuario");
            model.addAttribute("listaTipos", listaTipoUsuario);

            result.getAllErrors().forEach(error -> System.out.println("ERRROR:::>> "+error.toString()));
            return "formulario_usuario";
        }
        String messageFlash = (usuario.getId() !=null) ? "Usuario editado con exito!" : "Usuario creado con exito!";
        usuarioService.save(usuario);
        status.setComplete();
        flash.addFlashAttribute("success",messageFlash);
        return "redirect:listarUsu";
    }

    @GetMapping(value = "/cargar-personas/{term}", produces = {"application/json"})
    public @ResponseBody  List<Persona> cargarPersonas(@PathVariable String term){
        System.out.println("ENTRO 1.0: "+term);
        List<Persona> aaa = personaService.findByApellidoCompleto(term);
        System.out.println("ENTRO 2.0: "+aaa.size());

        return aaa;
    }

    @RequestMapping(value = "/delUsu/{id}")
    public String eliminar (@PathVariable(value = "id") Long id, RedirectAttributes flash){
        if(id > 0){
            usuarioService.delete(id);
            flash.addFlashAttribute("success","Usuario eliminado con exito!");
        }
        return "redirect:/usuario/listarUsu";

    }


}
