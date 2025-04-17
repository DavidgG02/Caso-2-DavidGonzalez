
package Caso.Caso.Controller;

import Caso.Caso.domain.Funcion;
import Caso.Caso.service.FuncionService;
import Caso.Caso.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/funciones")
public class FuncionController {

    @Autowired
    private FuncionService funcionService;

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public String listarFunciones(Model model) {
        model.addAttribute("funciones", funcionService.listarFuncionesActivas());
        return "funciones/listado";
    }

    @GetMapping("/{id}")
    public String verDetalleFuncion(@PathVariable Integer id, Model model) {
        funcionService.buscarPorId(id).ifPresent(funcion -> model.addAttribute("funcion", funcion));
        return "funciones/detalle";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/nueva")
    public String formularioNuevaFuncion(Model model) {
        model.addAttribute("funcion", new Funcion());
        model.addAttribute("peliculas", peliculaService.listarTodas());
        return "funciones/form";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/guardar")
    public String guardarFuncion(@Valid Funcion funcion, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("peliculas", peliculaService.listarTodas());
            return "funciones/form";
        }
        funcionService.guardarFuncion(funcion);
        return "redirect:/funciones";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/editar/{id}")
    public String editarFuncion(@PathVariable Integer id, Model model) {
        funcionService.buscarPorId(id).ifPresent(funcion -> model.addAttribute("funcion", funcion));
        model.addAttribute("peliculas", peliculaService.listarTodas());
        return "funciones/form";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/eliminar/{id}")
    public String eliminarFuncion(@PathVariable Integer id) {
        funcionService.eliminarFuncion(id);
        return "redirect:/funciones";
    }
}