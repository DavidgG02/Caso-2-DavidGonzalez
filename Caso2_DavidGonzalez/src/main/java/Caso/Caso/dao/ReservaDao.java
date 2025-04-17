package Caso.Caso.dao;

import Caso.Caso.domain.Funcion;
import Caso.Caso.domain.Reserva;
import Caso.Caso.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservaDao extends JpaRepository<Reserva, Integer> {
    List<Reserva> findByUsuario(Usuario usuario);
    List<Reserva> findByFuncion(Funcion funcion);
}
