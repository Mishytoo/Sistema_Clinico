package com.barrientos.sistema_clinico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/laboratorio")
//@SessionAttributes("laboratorio")
public class LaboratorioController {




    //formSolMue
    @RequestMapping(value = "/formSolMue")
    public String formSolMuestras(Model model) {
        model.addAttribute("titulo", "Solicitud de Muestras");
        return "solicitud_muestras";
    }

    //formRegMue
    @RequestMapping(value = "/formRegMue")
    public String formRegMuestras(Model model) {
        model.addAttribute("titulo", "Registro de Muestras");
        return "formulario_muestras";
    }

    //formSeaMue
    @RequestMapping(value = "/formSeaMue")
    public String formSeaMuestras(Model model) {
        model.addAttribute("titulo", "Busqueda de muestras");
        return "busqueda_muestras";
    }
}
