package br.com.gustavorochaEfelipeecardozo.votacao_gremio.Repository;

import br.com.gustavorochaEfelipeecardozo.votacao_gremio.entity.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EleitorRepository extends JpaRepository<Candidato, Long> {
}
