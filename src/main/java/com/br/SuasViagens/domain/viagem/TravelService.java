package com.br.SuasViagens.domain.viagem;

import java.util.List;

public interface TravelService {
    void addViagem(Travel travel);
    void refreshViagem(Travel travel);
    Travel findViagem(int idUsuario);
    Travel findAllViagem(int idUsuario);
    List<Travel> suarchViagem(Travel travelFiltro);
    void validViagem();
    void cancelViagem(int id);
    void deleteViagem(int id);
    double obterCustoTotalByIdUsuario(int idUsuario);
    int obterTotalDeViagens(int idUsuario);
}
