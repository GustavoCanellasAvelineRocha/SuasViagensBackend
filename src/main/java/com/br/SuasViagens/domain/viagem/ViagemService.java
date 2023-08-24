package com.br.SuasViagens.domain.viagem;

import java.util.List;

public interface ViagemService {
    void addViagem(Viagem viagem);
    void refreshViagem(Viagem viagem);
    Viagem findViagem(int idUsuario);
    Viagem findAllViagem(int idUsuario);
    List<Viagem> suarchViagem(Viagem viagemFiltro);
    void validViagem();
    void cancelViagem(int id);
    void deleteViagem(int id);
    double obterCustoTotalByIdUsuario(int idUsuario);
    int obterTotalDeViagens(int idUsuario);
}
