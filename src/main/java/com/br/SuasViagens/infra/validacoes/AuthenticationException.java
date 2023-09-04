package com.br.SuasViagens.infra.validacoes;

public class AuthenticationException extends RuntimeException{
    public AuthenticationException(String e) {
        super(e);
    }
}
