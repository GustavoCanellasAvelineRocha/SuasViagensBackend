package com.br.SuasViagens.domain.viagem;

import com.br.SuasViagens.domain.usuario.Usuario;

import java.util.List;

public record ViagemDTO(String id,
                        Usuario usuario,
                        String destino,
                        String duracao,
                        String modoDeTransporte,
                        String numeroDePassageiros,
                        List<String> listaDePassageiros,
                        String preco,
                        String status,
                        String dataViagem) {
}
