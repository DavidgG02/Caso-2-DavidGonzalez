package Caso.Caso.dao;

import Caso.Caso.domain.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeliculaDao extends JpaRepository<Pelicula, Integer> {

    List<Pelicula> findByTituloContainingIgnoreCase(String titulo);

    List<Pelicula> findByTipo(String tipo);

}
