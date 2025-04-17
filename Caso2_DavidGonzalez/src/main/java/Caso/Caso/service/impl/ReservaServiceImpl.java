package Caso.Caso.service.impl;

import Caso.Caso.domain.Reserva;
import Caso.Caso.domain.Usuario;
import Caso.Caso.domain.Funcion;
import Caso.Caso.dao.ReservaDao;
import Caso.Caso.service.ReservaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaServiceImpl implements ReservaService {
    private final ReservaDao reservaDao;

    @Autowired
    public ReservaServiceImpl(ReservaDao reservaDao) {
        this.reservaDao = reservaDao;
    }
 @Override
    public Reserva guardarReserva(Reserva reserva) {
        return reservaDao.save(reserva);
    }

    @Override
    public List<Reserva> listarTodas() {
        return reservaDao.findAll();
    }

    @Override
    public List<Reserva> buscarPorUsuario(Usuario usuario) {
        return reservaDao.findByUsuario(usuario);
    }

    @Override
    public List<Reserva> buscarPorFuncion(Funcion funcion) {
        return reservaDao.findByFuncion(funcion);
    }

    @Override
    public Optional<Reserva> buscarPorId(Integer id) {
        return reservaDao.findById(id);
    }

    @Override
    public void eliminarReserva(Integer id) {
        reservaDao.deleteById(id);
    }
}
