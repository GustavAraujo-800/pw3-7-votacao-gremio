package br.com.gustavorochaEfelipeecardozo.votacao_gremio.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name ="CANDIDATO_S" )
public class Candidato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_C")
    private Long id;

    @Column(name = "NOME_C")
    private String nome_c;

    @Column(name = "CATEGORIA")
    private String categoria;

    @Column(name = "QUANTIDADE_DE_VOTOS")
    private Integer quantidade_de_votos;

    @Column(name = "ELEITO")
    private String eleito;


}
