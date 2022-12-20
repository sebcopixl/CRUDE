package com.example.healtcare.controller;

import com.example.healtcare.domain.Paciente;
import com.example.healtcare.domain.SignosVitales;
import com.example.healtcare.service.IPacienteService;
import com.example.healtcare.service.PacienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller de la entidad {@link Paciente}
 * <p>
 * Todas las peticiones HTTP relacionadas al Paciente se capturan en este controlador.
 */
@Controller
public class PacienteController implements WebMvcConfigurer {
    private final Logger logger = LoggerFactory.getLogger(PacienteController.class);

    private final IPacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/")
    public String home() {
        logger.info("Home");
        return "redirect:/pacientes";
    }

    @GetMapping("/pacientes")
    public String listaPacientes(
            Model model
    ) {
        logger.info("Despliega la lista de pacientes");
        List<Paciente> pacientes = pacienteService.listarPaciente();
        model.addAttribute("pacientes", pacientes);
        return "paciente/list";
    }

    @GetMapping("/pacientes/new")
    public String nuevoPaciente(
            Model model
    ) {
        logger.info("Despliega el formulario para crear un paciente nuevo");
        model.addAttribute("paciente", new Paciente());
        return "paciente/new";
    }

    @PostMapping("/pacientes/new")
    public String agregarPaciente(
            @Valid Paciente paciente,
            BindingResult bindingResult,
            Model model
    ) {
        logger.info("Guarda un paciente nuevo");
        if (bindingResult.hasErrors()) {
            logger.info("Existen campos inválidos.");
            model.addAttribute("paciente", paciente);
            return "paciente/new";
        }

        pacienteService.guardar(paciente);
        return "redirect:/pacientes";
    }

    @GetMapping("/pacientes/{codigo}/editar")
    public String editarPaciente(
            @PathVariable(value = "codigo") Long codigo,
            Model model
    ) {
        logger.info("Despliega el formulario para editar un paciente con [codigo={}]", codigo);
        Paciente paciente = pacienteService.getPacienteByCodigo(codigo);
        model.addAttribute("paciente", paciente);
        model.addAttribute("signosVitalesRegistro", new SignosVitales(paciente));
        return "paciente/edit";
    }

    @PostMapping("/pacientes/guardar")
    public String guardarPaciente(
            @Valid Paciente paciente,
            BindingResult bindingResult,
            Model model
    ) {
        logger.info("Actualizando datos de paciente con codigo={}", paciente.getCodigo());

        if (bindingResult.hasErrors()) {
            logger.info("Error al guardar el paciente.");
            model.addAttribute("paciente", paciente);
            model.addAttribute("signosVitalesRegistro", new SignosVitales(paciente));
            return "paciente/edit";
        }

        logger.info("All fields of paciente are valid to save.");
        pacienteService.guardar(paciente);
        return "redirect:/pacientes";
    }

    @GetMapping("/pacientes/{codigo}/eliminar")
    public String eliminarPaciente(
            @PathVariable(value = "codigo") Long codigo
    ) {
        logger.info("Eliminar paciente con codigo: {}", codigo);
        pacienteService.eliminar(codigo);
        return "redirect:/pacientes";
    }

}
