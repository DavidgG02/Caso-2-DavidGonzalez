package Caso.Caso.Controller;

import Caso.Caso.service.PeliculaService;
import Caso.Caso.service.FuncionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app") // Prefijo para diferenciarlo
public class IndexController {
    @GetMapping("/home")
    public String home() {
        return "index";
    }
}