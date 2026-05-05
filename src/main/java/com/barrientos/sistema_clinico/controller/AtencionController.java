package com.barrientos.sistema_clinico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/atencion")
//@SessionAttributes("atencion")
public class AtencionController {

    //formRegPac
    @RequestMapping(value = "/formRegPac")
    public String formRegPaciente(Model model) {
        model.addAttribute("titulo","Registro de Paciente");
        return "formulario_paciente";
    }

    //formSeaPac
    @RequestMapping(value = "/formSeaPac")
    public String formSeaPaciente(Model model) {
        model.addAttribute("titulo","Busqueda de Paciente");
        return "busqueda_paciente";
    }

    //listarCit
    @RequestMapping(value = "/listarCit", method = RequestMethod.GET)
    public String listarPaciente(Model model) {
        model.addAttribute("titulo","Listado de Citas  de hoy");
        return "listar_cita";
    }


    @RequestMapping(value = "/formRegCit")
    public String formRegCita(Model model) {
        model.addAttribute("titulo","Registro de Cita");
        return "formulario_cita";
    }

    @RequestMapping(value = "/formEdiCit")
    public String formEdiCita(Model model) {
        model.addAttribute("titulo","Busqueda de Cita");
        return "busqueda_cita";
    }


    @RequestMapping(value = "/formDelCit")
    public String formDelCita(Model model) {
        model.addAttribute("titulo","Busqueda de Cita");
        return "busqueda_cita";
    }

}
