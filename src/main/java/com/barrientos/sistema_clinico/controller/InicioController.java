package com.barrientos.sistema_clinico.controller;

import com.barrientos.sistema_clinico.entity.Usuario;
import com.barrientos.sistema_clinico.service.IMenuItemService;
import com.barrientos.sistema_clinico.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/main")
public class InicioController {

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IMenuItemService menuItemService;


/*    @GetMapping({"/", "/inicio"})
    public String inicio(Authentication authentication, Model model) {

        String username = authentication.getName();

        boolean esAdministrador = tieneRol(authentication, "ROLE_ADMINISTRADOR");
        boolean esMedico = tieneRol(authentication, "ROLE_MEDICO_GENERAL");
        boolean esEnfermeria = tieneRol(authentication, "ROLE_ENFERMERIA");

        model.addAttribute("titulo", "Página principal");
        model.addAttribute("username", username);
        model.addAttribute("esAdministrador", esAdministrador);
        model.addAttribute("esMedico", esMedico);
        model.addAttribute("esEnfermeria", esEnfermeria);

        return "inicio";
    }*/

    private boolean tieneRol(Authentication authentication, String rol) {
        return authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(rol::equals);
    }


    @GetMapping({"/", "/inicio"})
    public String inicio(Model model) { //Authentication authentication,

        /*Usuario usuario = usuarioService.findByNomUsuario(authentication.getName())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        String codigoRol = usuario.getTipoUsuario().getCodigoRol();*/

        model.addAttribute("titulo", "Menú principal");
        /*model.addAttribute("username",
                usuario.getPersona().getApellidoCompleto().toUpperCase() + ", "+
                usuario.getPersona().getNombreCompleto().toUpperCase() );
        model.addAttribute("tipoUsuario", usuario.getTipoUsuario().getTipoUsuario());
        model.addAttribute("codigoRol", codigoRol);
        model.addAttribute("claseRol", obtenerClaseRol(codigoRol));
        model.addAttribute("badgeRol", obtenerBadgeRol(codigoRol));
        model.addAttribute("menuGrupos",
                menuItemService.findMenuAgrupadoByTipoUsuario(usuario.getTipoUsuario().getId()));
*/

        return "inicio";
    }

}