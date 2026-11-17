package br.com.gustavorochaEfelipeecardozo.votacao_gremio.Service;

import br.com.gustavorochaEfelipeecardozo.votacao_gremio.Repository.EleitorRepository;
import br.com.gustavorochaEfelipeecardozo.votacao_gremio.entity.Eleitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EleitorService {

    @Autowired
    private EleitorRepository eleitorRepository;

    public List<Eleitor> listarTodos() {
        return eleitorRepository.findAll();
    }

    public Eleitor buscarPorId(Long id) {
        return eleitorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Eleitor não encontrado com ID: " + id));
    }

    public Eleitor cadastrar(Eleitor eleitor) {
        if (eleitor.getCpf() != null && eleitorRepository.existsByCpf(eleitor.getCpf())) {
            throw new RuntimeException("CPF já cadastrado!");
        }
        if (eleitor.getGmail() != null && eleitorRepository.existsByGmail(eleitor.getGmail())) {
            throw new RuntimeException("E-mail já cadastrado!");
        }
        eleitor.setId(null);
        return eleitorRepository.save(eleitor);
    }

    public Eleitor atualizar(Long id, Eleitor dados) {
        Eleitor existente = buscarPorId(id);
        existente.setNome_e(dados.getNome_e());
        existente.setGmail(dados.getGmail());
        existente.setSenha(dados.getSenha());
        existente.setCpf(dados.getCpf());
        return eleitorRepository.save(existente);
    }

    public void deletar(Long id) {
        Eleitor existente = buscarPorId(id);
        eleitorRepository.delete(existente);
    }
}
