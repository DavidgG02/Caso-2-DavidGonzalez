package Caso.Caso.service;

import Caso.Caso.domain.Reserva;
import Caso.Caso.domain.Usuario;
import Caso.Caso.domain.Funcion;
import java.util.List;
import java.util.Optional;

public interface ReservaService {

    Reserva guardarReserva(Reserva reserva);

    List<Reserva> listarTodas();

    List<Reserva> buscarPorUsuario(Usuario usuario);

    List<Reserva> buscarPorFuncion(Funcion funcion);

    Optional<Reserva> buscarPorId(Integer id);

    void eliminarReserva(Integer id);

}
