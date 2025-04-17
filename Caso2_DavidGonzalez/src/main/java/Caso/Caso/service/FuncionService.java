package Caso.Caso.service;

import Caso.Caso.domain.Funcion;
import Caso.Caso.domain.Pelicula;
import java.util.List;
import java.util.Optional;

public interface FuncionService {

    Funcion guardarFuncion(Funcion funcion);

    List<Funcion> listarTodas();

    List<Funcion> listarFuncionesActivas();

    List<Funcion> buscarPorPelicula(Pelicula pelicula);

    List<Funcion> buscarPorPeliculaActivas(Pelicula pelicula);

    Optional<Funcion> buscarPorId(Integer id);

    void eliminarFuncion(Integer id);
}