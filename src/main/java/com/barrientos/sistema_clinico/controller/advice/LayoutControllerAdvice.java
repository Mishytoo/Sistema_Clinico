package com.barrientos.sistema_clinico.controller.advice;

import com.barrientos.sistema_clinico.entity.Usuario;
import com.barrientos.sistema_clinico.service.IMenuItemService;
import com.barrientos.sistema_clinico.service.IUsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice(annotations = Controller.class)
public class LayoutControllerAdvice {

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IMenuItemService menuItemService;

    @ModelAttribute
    public void agregarDatosLayout(Model model, Authentication authentication, HttpServletRequest request) {

        if (authentication == null ||
                !authentication.isAuthenticated() ||
                authentication instanceof AnonymousAuthenticationToken) {
            return;
        }

        Usuario usuario = usuarioService.findByNomUsuario(authentication.getName())
                .orElse(null);

        if (usuario == null) {
            return;
        }

        String currentPath = request.getRequestURI();

        String contextPath = request.getContextPath();
        if (contextPath != null && !contextPath.isBlank() && currentPath.startsWith(contextPath)) {
            currentPath = currentPath.substring(contextPath.length());
        }

        model.addAttribute("currentPath", currentPath);

        String codigoRol = usuario.getTipoUsuario().getCodigoRol();

        model.addAttribute("username",
                usuario.getPersona().getApellidoCompleto().toUpperCase() + ", " +
                        usuario.getPersona().getNombreCompleto().toUpperCase()
        );

        model.addAttribute("tipoUsuario", usuario.getTipoUsuario().getTipoUsuario());
        model.addAttribute("codigoRol", codigoRol);
        model.addAttribute("claseRol", obtenerClaseRol(codigoRol));
        model.addAttribute("badgeRol", obtenerBadgeRol(codigoRol));

        model.addAttribute("menuGrupos",
                menuItemService.findMenuAgrupadoByTipoUsuario(usuario.getTipoUsuario().getId())
        );

        if (!model.containsAttribute("titulo")) {
            model.addAttribute("titulo", "Sistema clínico");
        }
    }

    private String obtenerClaseRol(String codigoRol) {
        return switch (codigoRol) {
            case "ADMINISTRADOR" -> "bg-dark text-white";
            case "MEDICO_GENERAL" -> "bg-success text-white";
            case "ENFERMERIA" -> "bg-info text-white";
            case "RECEPCION" -> "bg-primary bg-gradient text-white";
            case "LABORATORIO" -> "bg-warning bg-gradient text-white";
            case "FARMACIA" -> "bg-secondary text-white";
            default -> "bg-dark text-white";
        };
    }

    private String obtenerBadgeRol(String codigoRol) {
        return switch (codigoRol) {
            case "ADMINISTRADOR" -> "badge-info";
            case "MEDICO_GENERAL", "RECEPCION" -> "badge-secondary";
            case "ENFERMERIA" -> "badge-secondary";
            case "LABORATORIO" -> "badge-secondary";
            case "FARMACIA" -> "badge-info";
            default -> "badge-info";
        };
    }
}