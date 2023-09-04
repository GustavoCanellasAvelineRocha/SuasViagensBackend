package com.br.SuasViagens.infra;

import com.br.SuasViagens.infra.validacoes.AuthenticationException;
import com.br.SuasViagens.infra.validacoes.BusinessRulesException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErro400(MethodArgumentNotValidException exception){
        List<FieldError> error = exception.getFieldErrors();
        return ResponseEntity.badRequest().body(error.stream().map(DadosErroValidacao::new).toList());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404(MethodArgumentNotValidException exception){
        List<FieldError> error = exception.getFieldErrors();
        return ResponseEntity.badRequest().body(error.stream().map(DadosErroValidacao::new).toList());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(AuthenticationException.class)
    public ResponseEntity tratarErroAutenticacao(AuthenticationException exception){
        return ResponseEntity.badRequest().body(exception.getLocalizedMessage());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(BusinessRulesException.class)
    public ResponseEntity tratarErroDeRegraDeNegocio(BusinessRulesException exception){
        return ResponseEntity.badRequest().body(exception.getLocalizedMessage());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity tratarErro500(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getLocalizedMessage());
    }

    private record DadosErroValidacao(String field, String msg){
        public DadosErroValidacao(FieldError error){
            this(error.getField(),error.getDefaultMessage());
        }
    }
}

