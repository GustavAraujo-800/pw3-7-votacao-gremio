package br.com.gustavorochaEfelipeecardozo.votacao_gremio.Service;

import br.com.gustavorochaEfelipeecardozo.votacao_gremio.Repository.CandidatoRepository;
import br.com.gustavorochaEfelipeecardozo.votacao_gremio.entity.Candidato;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    // GET - Lista candidatos ordenados por votos
    public List<Candidato> listarTodos() {
        return candidatoRepository.listarOrdenadosPorVotos();
    }

    // GET/{id} - Consulta candidato individual
    public Candidato buscarPorId(Long id) {
        return candidatoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidato não encontrado com ID: " + id));
    }

    // POST - Cadastra novo candidato (quantidade_de_votos = 0, eleito = "Não")
    public Candidato cadastrar(Candidato candidato) {
        candidato.setId(null);
        candidato.setQuantidade_de_votos(0);
        candidato.setEleito("Não");
        return candidatoRepository.save(candidato);
    }

    // PUT/{id} - Edita dados do candidato
    public Candidato atualizar(Long id, Candidato dadosAtualizados) {
        Candidato existente = buscarPorId(id);
        String categoriaAntiga = existente.getCategoria();

        existente.setNome_c(dadosAtualizados.getNome_c());
        existente.setCategoria(dadosAtualizados.getCategoria());
        Candidato salvo = candidatoRepository.save(existente);

        reavaliarEleitoNaCategoria(categoriaAntiga);
        reavaliarEleitoNaCategoria(salvo.getCategoria());

        return salvo;
    }

    // DELETE/{id} - Remove candidato
    public void deletar(Long id) {
        Candidato candidato = buscarPorId(id);
        String categoria = candidato.getCategoria();
        candidatoRepository.delete(candidato);
        reavaliarEleitoNaCategoria(categoria);
    }

    // POST/{id}/votar - Regra de Negócio: +1 voto e reavalia o líder da categoria
    @Transactional
    public Candidato registrarVoto(Long candidatoId) {
        Candidato candidatoVotado = buscarPorId(candidatoId);
        int votosAtuais = candidatoVotado.getQuantidade_de_votos() != null ? candidatoVotado.getQuantidade_de_votos() : 0;
        candidatoVotado.setQuantidade_de_votos(votosAtuais + 1);
        candidatoRepository.save(candidatoVotado);

        reavaliarEleitoNaCategoria(candidatoVotado.getCategoria());

        return buscarPorId(candidatoId);
    }

    // Pseudocódigo da Regra de Negócio adaptado para String ("Sim" / "Não")
    private void reavaliarEleitoNaCategoria(String categoria) {
        List<Candidato> todosDaCategoria = candidatoRepository.findByCategoria(categoria);

        int maiorVotacao = todosDaCategoria.stream()
                .mapToInt(c -> c.getQuantidade_de_votos() != null ? c.getQuantidade_de_votos() : 0)
                .max()
                .orElse(0);

        for (Candidato c : todosDaCategoria) {
            int votos = c.getQuantidade_de_votos() != null ? c.getQuantidade_de_votos() : 0;
            if (votos == maiorVotacao && maiorVotacao > 0) {
                c.setEleito("Sim");
            } else {
                c.setEleito("Não");
            }
            candidatoRepository.save(c);
        }
    }
}
