package Caso.Caso.service.impl;

import Caso.Caso.domain.Usuario;
import Caso.Caso.dao.UsuarioDao;
import Caso.Caso.service.UsuarioService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioDao usuarioDao;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioServiceImpl(UsuarioDao usuarioDao, PasswordEncoder passwordEncoder) {
        this.usuarioDao = usuarioDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        if (usuario.getId() == null || !usuario.getContrasena().startsWith("$2a$")) {
            usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        }
        return usuarioDao.save(usuario);
    }

    @Override
    public List<Usuario> listarTodos() {
        return usuarioDao.findAll();
    }

    @Override
    public Optional<Usuario> buscarPorId(Integer id) {
        return usuarioDao.findById(id);
    }

    @Override
    public Optional<Usuario> buscarPorCorreo(String correo) {
        return usuarioDao.findByCorreo(correo);
    }

    @Override
    public void eliminarUsuario(Integer id) {
        usuarioDao.deleteById(id);
    }

    @Override
    public boolean existePorCorreo(String correo) {
        return usuarioDao.existsByCorreo(correo);
    }
}
