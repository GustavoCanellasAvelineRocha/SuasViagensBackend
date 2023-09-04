package com.br.SuasViagens.domain.viagem;

import com.br.SuasViagens.domain.usuario.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "viagem")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Travel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private User User;
    private String destination;
    private int duration;
    private String transport;
    private TravelType typeOfTravel;
    private double preco;
    private TravelStatus TravelStatus;
    private LocalDate dataViagem;

}
