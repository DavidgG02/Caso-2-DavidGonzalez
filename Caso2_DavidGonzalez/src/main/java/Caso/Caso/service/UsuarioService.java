package Caso.Caso.service;

import Caso.Caso.domain.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    Usuario guardarUsuario(Usuario usuario);

    List<Usuario> listarTodos();

    Optional<Usuario> buscarPorId(Integer id);

    Optional<Usuario> buscarPorCorreo(String correo);

    void eliminarUsuario(Integer id);

    boolean existePorCorreo(String correo);
}
