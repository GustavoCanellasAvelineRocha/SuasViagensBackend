package com.br.SuasViagens.infra.validacoes;

public class BusinessRulesException extends RuntimeException{
    public BusinessRulesException(String s) {
        super(s);
    }
}
