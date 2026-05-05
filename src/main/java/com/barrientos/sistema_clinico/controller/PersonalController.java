package com.barrientos.sistema_clinico.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/personal")
@SessionAttributes("personal")
public class PersonalController {

    @RequestMapping(value = "/listarEmp", method = RequestMethod.GET)
    public String listarEmpleado(Model model) {
        model.addAttribute("titulo", "Listado de Empleados");
        return "listaR_empleado";
    }


    @RequestMapping(value = "/formRegEmp")
    public String formRegEmpleado(Model model) {
        model.addAttribute("titulo", "Registro de Empleado");
        return "formulario_empleado";
    }


    @RequestMapping(value = "/formSeaEmp")
    public String formSeaEmpleado(Model model) {
        model.addAttribute("titulo", "Busqueda de Empleado");
        return "busqueda_empleado";
    }

}
