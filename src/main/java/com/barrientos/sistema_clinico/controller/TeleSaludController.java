package com.barrientos.sistema_clinico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/telemedicina")
//@SessionAttributes("telemedicina")
public class TeleSaludController {


    @RequestMapping(value = "/agendados")
    public String agenda(Model model) {
        model.addAttribute("titulo", "Citas Virtuales Agendadas");
        return "telemedicina_agenda";
    }


    @RequestMapping(value = "/socket")
    public String socket(Model model) {
        model.addAttribute("titulo", "Panel de Videoconferencia");
        return "telemedicina_socket";
    }


    @RequestMapping(value = "/historial")
    public String historial(Model model) {
        model.addAttribute("titulo", "Historial de Citas Virtuales");
        return "telemedicina_historial";
    }

}
