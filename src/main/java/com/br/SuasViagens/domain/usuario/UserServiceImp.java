package com.br.SuasViagens.domain.usuario;

import com.br.SuasViagens.infra.validacoes.AuthenticationException;
import com.br.SuasViagens.infra.validacoes.BusinessRulesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User autenticar(String email, String senha) {
        Optional<User> usuario = userRepository.findByEmail(email);

        if(usuario.isEmpty()){
            throw new AuthenticationException("Usuario nao encontrado");
        }

        if(!usuario.get().getSenha().equals(senha)){
            throw new AuthenticationException("Senha incorreta");
        }

        return usuario.get();
    }

    @Override
    @Transactional
    public User salvarUsuario(User user) {
        validarEmail(user.getEmail());
        return userRepository.save(user);
    }

    @Override
    public void validarEmail(String email) {
        if(email == null || email.equals("")) throw new BusinessRulesException("Digite um email compativel");

        boolean existe = userRepository.existsByEmail(email);
        if (existe) throw new BusinessRulesException("ja existe um usuario cadastrado com este email.");
    }

    @Override
    public User findById(Long idUsuario) {
        var usuario = userRepository.findById(idUsuario);

        if (usuario.isPresent())return usuario.get();
        else throw new BusinessRulesException("Usuario nao encontrado");
    }

    @Override
    public boolean existsById(Long idUsuario) {
        return userRepository.existsById(idUsuario);
    }
}
