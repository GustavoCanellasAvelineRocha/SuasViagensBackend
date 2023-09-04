package com.br.SuasViagens.controller;

import com.br.SuasViagens.domain.usuario.User;
import com.br.SuasViagens.domain.usuario.UserDTO;
import com.br.SuasViagens.domain.usuario.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/autenticar")
    public ResponseEntity autenticar(@RequestBody UserDTO userDTO){
        User userAutenticado = userService.autenticar(userDTO.email(), userDTO.senha());
        return ResponseEntity.ok(userAutenticado);
    }

    @PostMapping
    @Transactional
    public ResponseEntity salvar(@RequestBody UserDTO userDTO){
        User user = User.builder().nome(userDTO.nome())
                .email(userDTO.email())
                .senha(userDTO.senha())
                .data_cadastro(LocalDate.now())
                .build();
        userService.salvarUsuario(user);
        return new ResponseEntity(userDTO, HttpStatus.CREATED);
    }
}
