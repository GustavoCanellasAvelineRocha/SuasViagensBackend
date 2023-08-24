package com.br.SuasViagens.infra.validacoes;

public class RegraNegocioException extends RuntimeException{
    public RegraNegocioException(String s) {
        super(s);
    }
}
