package Caso.Caso.service;

import Caso.Caso.domain.Pelicula;
import java.util.List;
import java.util.Optional;

public interface PeliculaService {

    Pelicula guardarPelicula(Pelicula pelicula);

    List<Pelicula> listarTodas();

    List<Pelicula> buscarPorTitulo(String titulo);

    List<Pelicula> buscarPorTipo(String tipo);

    Optional<Pelicula> buscarPorId(Integer id);

    void eliminarPelicula(Integer id);

}
