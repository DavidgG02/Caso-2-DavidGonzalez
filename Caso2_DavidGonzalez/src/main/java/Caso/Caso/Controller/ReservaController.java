package Caso.Caso.Controller;

import Caso.Caso.domain.Funcion;
import Caso.Caso.domain.Reserva;
import Caso.Caso.domain.Usuario;
import Caso.Caso.service.FuncionService;
import Caso.Caso.service.ReservaService;
import Caso.Caso.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private FuncionService funcionService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String listarReservasUsuario(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        String correo = userDetails.getUsername(); // asumimos que el username es el correo
        Usuario usuario = usuarioService.buscarPorCorreo(correo).orElse(null);

        if (usuario != null) {
            model.addAttribute("reservas", reservaService.buscarPorUsuario(usuario));
        } else {
            model.addAttribute("reservas", null); 
        }

        return "reservas/listado";
    }

    @GetMapping("/nueva/{idFuncion}")
    public String nuevaReserva(@PathVariable Integer idFuncion, Model model) {
        model.addAttribute("reserva", new Reserva());
        Funcion funcion = funcionService.buscarPorId(idFuncion).orElse(null);
        model.addAttribute("funcion", funcion);
        return "reservas/form";
    }

    @PostMapping("/guardar")
    public String guardarReserva(@ModelAttribute Reserva reserva,
            @RequestParam("idFuncion") Integer idFuncion,
            @AuthenticationPrincipal UserDetails userDetails) {

        String correo = userDetails.getUsername(); 
        Usuario usuario = usuarioService.buscarPorCorreo(correo).orElse(null);
        Funcion funcion = funcionService.buscarPorId(idFuncion).orElse(null);

        if (usuario != null && funcion != null) {
            reserva.setUsuario(usuario);
            reserva.setFuncion(funcion);
            reservaService.guardarReserva(reserva);
        }

        return "redirect:/reservas";
    }

    @GetMapping("/cancelar/{id}")
    public String cancelarReserva(@PathVariable Integer id) {
        reservaService.eliminarReserva(id);
        return "redirect:/reservas";
    }
}
