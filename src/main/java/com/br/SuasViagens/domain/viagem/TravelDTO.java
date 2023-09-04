package com.br.SuasViagens.domain.viagem;

import com.br.SuasViagens.domain.usuario.User;

import java.util.List;

public record TravelDTO(String id,
                        User user,
                        String destino,
                        String duracao,
                        String modoDeTransporte,
                        String numeroDePassageiros,
                        List<String> listaDePassageiros,
                        String preco,
                        String status,
                        String dataViagem) {
}
