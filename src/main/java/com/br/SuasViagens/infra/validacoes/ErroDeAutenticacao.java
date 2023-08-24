package com.br.SuasViagens.infra.validacoes;

public class ErroDeAutenticacao extends RuntimeException{
    public ErroDeAutenticacao(String e) {
        super(e);
    }
}
