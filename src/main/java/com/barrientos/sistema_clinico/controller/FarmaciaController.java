package com.barrientos.sistema_clinico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/farmacia")
//@SessionAttributes("farmacia")
public class FarmaciaController {

    //listarMed
    @RequestMapping(value = "/listarMed", method = RequestMethod.GET)
    public String listarMedicamentos(Model model) {
        model.addAttribute("titulo", "Listado de Medicamentos");
        return "listar_medicamentos";
    }

    //formRegMed
    @RequestMapping(value = "/formRegMed")
    public String formRegMedicamentos(Model model) {
        model.addAttribute("titulo", "Registro de Medicamentos");
        return "formulario_medicamentos";
    }

    //listarMed
    @RequestMapping(value = "/listarMedXVen", method = RequestMethod.GET)
    public String listarMedicamentosXVencer(Model model) {
        model.addAttribute("titulo", "Medicamentos por Vencer");
        return "listar_medicamentos";
    }

    //formPedMed
    @RequestMapping(value = "/formPedMed")
    public String formPedMedicamentos(Model model) {
        model.addAttribute("titulo", "Pedido de Medicamentos");
        return "pedido_medicamentos";
    }

}
