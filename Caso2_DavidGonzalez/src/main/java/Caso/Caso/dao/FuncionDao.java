package Caso.Caso.dao;

import Caso.Caso.domain.Funcion;
import Caso.Caso.domain.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FuncionDao extends JpaRepository<Funcion, Integer> {
    List<Funcion> findByPelicula(Pelicula pelicula);
    List<Funcion> findByFechaGreaterThanEqual(LocalDate fecha);
    List<Funcion> findByPeliculaAndFechaGreaterThanEqual(Pelicula pelicula, LocalDate fecha);
}