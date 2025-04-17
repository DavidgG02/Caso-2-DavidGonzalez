package Caso.Caso.service.impl;

import Caso.Caso.domain.Funcion;
import Caso.Caso.domain.Pelicula;
import Caso.Caso.dao.FuncionDao;
import Caso.Caso.service.FuncionService;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionServiceImpl implements FuncionService {

    private final FuncionDao funcionDao;

    @Autowired
    public FuncionServiceImpl(FuncionDao funcionDao) {
        this.funcionDao = funcionDao;
    }

    @Override
    public Funcion guardarFuncion(Funcion funcion) {
        return funcionDao.save(funcion);
    }

    @Override
    public List<Funcion> listarTodas() {
        return funcionDao.findAll();
    }

    @Override
    public List<Funcion> listarFuncionesActivas() {
        return funcionDao.findByFechaGreaterThanEqual(LocalDate.now());
    }

    @Override
    public List<Funcion> buscarPorPelicula(Pelicula pelicula) {
        return funcionDao.findByPelicula(pelicula);
    }

    @Override
    public List<Funcion> buscarPorPeliculaActivas(Pelicula pelicula) {
        return funcionDao.findByPeliculaAndFechaGreaterThanEqual(pelicula, LocalDate.now());
    }

    @Override
    public Optional<Funcion> buscarPorId(Integer id) {
        return funcionDao.findById(id);
    }

    @Override
    public void eliminarFuncion(Integer id) {
        funcionDao.deleteById(id);
    }

}
