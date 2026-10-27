package br.com.gustavorochaEfelipeecardozo.votacao_gremio.Repository;

import br.com.gustavorochaEfelipeecardozo.votacao_gremio.Enum.Candidatos_nomes;
import br.com.gustavorochaEfelipeecardozo.votacao_gremio.entity.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato,Long> {

    List<Candidato> findByNome(Candidatos_nomes nome);
}
