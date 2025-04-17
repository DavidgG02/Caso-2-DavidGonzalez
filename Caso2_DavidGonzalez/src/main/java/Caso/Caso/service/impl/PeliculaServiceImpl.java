package Caso.Caso.service.impl;

import Caso.Caso.domain.Pelicula;
import Caso.Caso.dao.PeliculaDao;
import Caso.Caso.service.PeliculaService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    private final PeliculaDao peliculaDao;

    @Autowired
    public PeliculaServiceImpl(PeliculaDao peliculaDao) {
        this.peliculaDao = peliculaDao;
    }

    @Override
    public Pelicula guardarPelicula(Pelicula pelicula) {
        return peliculaDao.save(pelicula);
    }

    @Override
    public List<Pelicula> listarTodas() {
        return peliculaDao.findAll();
    }

    @Override
    public List<Pelicula> buscarPorTitulo(String titulo) {
        return peliculaDao.findByTituloContainingIgnoreCase(titulo);
    }

    @Override
    public List<Pelicula> buscarPorTipo(String tipo) {
        return peliculaDao.findByTipo(tipo);
    }

    @Override
    public Optional<Pelicula> buscarPorId(Integer id) {
        return peliculaDao.findById(id);
    }

    @Override
    public void eliminarPelicula(Integer id) {
        peliculaDao.deleteById(id);
    }
}
