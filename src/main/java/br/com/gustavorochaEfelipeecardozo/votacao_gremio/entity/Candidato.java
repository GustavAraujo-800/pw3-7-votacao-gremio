package br.com.gustavorochaEfelipeecardozo.votacao_gremio.entity;


import br.com.gustavorochaEfelipeecardozo.votacao_gremio.Enum.Candidatos_nomes;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "NOME_C")
    private Candidatos_nomes nome_c;

    @Column(name = "CATEGORIA")
    private String categoria;

    @Column(name = "QUANTIDADE_DE_VOTOS")
    private Integer quantidade_de_votos;

    @Column(name = "ELEITO")
    private String eleito;


}
