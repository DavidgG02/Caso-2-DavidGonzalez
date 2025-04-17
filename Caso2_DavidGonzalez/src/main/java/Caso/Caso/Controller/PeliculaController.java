package Caso.Caso.Controller;

import Caso.Caso.domain.Pelicula;
import Caso.Caso.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public String listarPeliculas(Model model) {
        model.addAttribute("peliculas", peliculaService.listarTodas());
        return "peliculas/listado";
    }

    @GetMapping("/{id}")
    public String verDetallePelicula(@PathVariable Integer id, Model model) {
        peliculaService.buscarPorId(id).ifPresent(pelicula -> model.addAttribute("pelicula", pelicula));
        return "peliculas/detalle";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/nuevo")
    public String formularioNuevaPelicula(Model model) {
        model.addAttribute("pelicula", new Pelicula());
        return "peliculas/form";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/guardar")
    public String guardarPelicula(@Valid Pelicula pelicula, BindingResult result) {
        if (result.hasErrors()) {
            return "peliculas/form";
        }
        peliculaService.guardarPelicula(pelicula);
        return "redirect:/peliculas";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/editar/{id}")
    public String editarPelicula(@PathVariable Integer id, Model model) {
        peliculaService.buscarPorId(id).ifPresent(pelicula -> model.addAttribute("pelicula", pelicula));
        return "peliculas/form";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/eliminar/{id}")
    public String eliminarPelicula(@PathVariable Integer id) {
        peliculaService.eliminarPelicula(id);
        return "redirect:/peliculas";
    }
}