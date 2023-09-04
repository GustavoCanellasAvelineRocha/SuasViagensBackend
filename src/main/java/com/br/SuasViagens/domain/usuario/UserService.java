package com.br.SuasViagens.domain.usuario;

public interface UserService {
    User autenticar(String email, String senha);
    User salvarUsuario(User user);
    void validarEmail(String email);

    User findById(Long idUsuario);
    boolean existsById(Long idUsuario);
}
