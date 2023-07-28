package com.example.healtcare.controller;

import com.example.healtcare.domain.Paciente;
import com.example.healtcare.domain.SignosVitales;
import com.example.healtcare.service.SignosVitalesService;
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
import java.text.MessageFormat;

@Controller
public class SignosVitalesController implements WebMvcConfigurer {
    private final Logger logger = LoggerFactory.getLogger(SignosVitalesController.class);

    private final SignosVitalesService service;

    @Autowired
    public SignosVitalesController(SignosVitalesService service) {
        this.service = service;
    }

    @PostMapping("/pacientes/{codigo}/signosVitalesRegistros/new")
    public String agregarSignosVitales(
            @PathVariable(value = "codigo") Long codigo,
            @Valid SignosVitales signosVitales,
            BindingResult bindingResult,
            Model model
    ) {
        logger.info("Guarda registro de los signos vitales del paciente con codigo: {}", codigo);
        if (bindingResult.hasErrors()) {
            logger.info("Existen campos inválidos.");
            model.addAttribute("signosVitales", signosVitales);
            model.addAttribute("paciente", signosVitales.getPaciente());
            return "paciente/edit";
        }

        service.guardar(signosVitales);
        model.addAttribute("signosVitales", signosVitales);
        model.addAttribute("paciente", signosVitales.getPaciente());
        return MessageFormat.format("redirect:/pacientes/{0}/editar", codigo);
    }

    @GetMapping("/pacientes/{codigo}/signosVitalesRegistros/{id}/editar")
    public String editarSignosVitalesForm(
            @PathVariable(value = "codigo") Long codigo,
            @PathVariable(value = "id") Long id,
            Model model
    ) {
        logger.info("Despliega el formulario para editar el signo vital con [id={}] del paciente con [codigo={}]", id, codigo);
        SignosVitales signosVitales = service.getSignoVitalById(id);
        model.addAttribute("signosVitales", signosVitales);
        model.addAttribute("paciente", signosVitales.getPaciente());
        return "signosvitales/edit";
    }

    @PostMapping("/pacientes/{codigo}/signosVitalesRegistros/{id}/editar")
    public String editarSignosVitales(
            @PathVariable(value = "codigo") Long codigo,
            @PathVariable(value = "id") Long id,
            @Valid SignosVitales signosVitales,
            BindingResult bindingResult,
            Model model
    ) {
        logger.info("Actualizando los signos vitales con [id={}] del paciente con [codigo={}]", id, codigo);
        if (bindingResult.hasErrors()) {
            logger.info("Error al actualizar los signos vitales.");
            model.addAttribute("signosVitales", signosVitales);
            model.addAttribute("paciente", signosVitales.getPaciente());
            return "signosvitales/edit";
        }

        service.actualizar(id, signosVitales);

        return MessageFormat.format("redirect:/pacientes/{0}/editar", codigo);
    }

    @GetMapping("/pacientes/{codigo}/signosVitalesRegistros/{id}/eliminar")
    public String eliminarSignosVitales(
            @PathVariable(value = "codigo") Long codigo,
            @PathVariable(value = "id") Long id
    ) {
        logger.info("Eliminar los signos vitales del paciente con codigo {} e identificaor {}", codigo, id);
        service.eliminar(id);
        return MessageFormat.format("redirect:/pacientes/{0}/editar", codigo);
    }
}
