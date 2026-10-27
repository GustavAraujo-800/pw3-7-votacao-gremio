package br.com.gustavorochaEfelipeecardozo.votacao_gremio.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name ="ELEITOR_S" )
public class Eleitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_E")
    private Long id;

    @Column(name = "NOME_E")
    private String nome_e;

    @Column(name = "GMAIL")
    private String gmail;

    @Column(name = "SENHA")
    private String senha;

    @Column(name = "CPF")
    private String cpf;
}
