package com.br.SuasViagens.controller;

import com.br.SuasViagens.domain.usuario.User;
import com.br.SuasViagens.domain.usuario.UserDTO;
import com.br.SuasViagens.domain.usuario.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/usuarios")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/autenticar")
    public ResponseEntity<?> autenticar(@RequestBody @Valid UserDTO userDTO) {
        try {
            User userAutenticado = userService.autenticar(userDTO.email(), userDTO.senha());
            return ResponseEntity.ok(userAutenticado);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Credenciais inválidas: " + ex.getMessage());
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> salvar(@RequestBody @Valid UserDTO userDTO) {
        try {
            User user = User.builder()
                    .nome(userDTO.nome())
                    .email(userDTO.email())
                    .senha(userDTO.senha())
                    .data_cadastro(LocalDate.now())
                    .build();

            User savedUser = userService.salvarUsuario(user);

            URI location = URI.create("/api/usuarios/" + savedUser.getId());
            return ResponseEntity.created(location).body("Usuário criado com sucesso.");
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao salvar usuário: " + ex.getMessage());
        }
    }
}
