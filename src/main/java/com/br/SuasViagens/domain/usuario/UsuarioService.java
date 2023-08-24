package com.br.SuasViagens.domain.usuario;

public interface UsuarioService {
    Usuario autenticar(String email,String senha);
    Usuario salvarUsuario(Usuario usuario);
    void validarEmail(String email);

    Usuario findById(Long idUsuario);
    boolean existsById(Long idUsuario);
}
