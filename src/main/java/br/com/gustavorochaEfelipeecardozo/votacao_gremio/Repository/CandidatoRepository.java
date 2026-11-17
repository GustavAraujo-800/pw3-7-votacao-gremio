package br.com.gustavorochaEfelipeecardozo.votacao_gremio.Repository;

import br.com.gustavorochaEfelipeecardozo.votacao_gremio.Enum.Candidatos_nomes;
import br.com.gustavorochaEfelipeecardozo.votacao_gremio.entity.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato,Long> {

    @Query("SELECT c FROM Candidato c WHERE c.nome_c = :nome")
    List<Candidato> findByNome(Candidatos_nomes nome);

    // Ordena os candidatos do mais votado para o menos votado
    @Query("SELECT c FROM Candidato c ORDER BY c.quantidade_de_votos DESC")
    List<Candidato> listarOrdenadosPorVotos();

    // Busca todos da mesma categoria para aplicar a regra de negócio do líder
    List<Candidato> findByCategoria(String categoria);
}
