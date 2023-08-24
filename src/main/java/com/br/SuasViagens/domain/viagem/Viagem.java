package com.br.SuasViagens.domain.viagem;

import com.br.SuasViagens.domain.usuario.Usuario;
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
public class Viagem {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario Usuario;
    private String destino;
    private int duracao;
    private String modoDeTransporte;
    //fazer Enum
    private String tipoDeViagem;
    private double preco;
    //fazer Enum
    private String status;
    private LocalDate dataViagem;

}
