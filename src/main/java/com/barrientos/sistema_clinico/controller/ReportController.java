package com.barrientos.sistema_clinico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/report")
//@SessionAttributes("report")
public class ReportController {

    @RequestMapping(value = "/RepCit", method = RequestMethod.GET)
    public String RepCitas(Model model) {
        model.addAttribute("titulo", "Reporte de Citas");
        return "reporte_citas";
    }

    @RequestMapping(value = "/RepTel", method = RequestMethod.GET)
    public String RepTelemedicina(Model model) {
        model.addAttribute("titulo", "Reporte de Telemedicina");
        return "reporte_telemedicina";
    }

    @RequestMapping(value = "/RepAre", method = RequestMethod.GET)
    public String RepAreas(Model model) {
        model.addAttribute("titulo", "Reporte de Areas mas demandadas");
        return "reporte_areas";
    }

    @RequestMapping(value = "/repMed", method = RequestMethod.GET)
    public String repMedicamentos(Model model) {
        model.addAttribute("titulo", "Reporte de Medicamentos");
        return "reporte_medicamentos";
    }

}
