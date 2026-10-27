package br.com.gustavorochaEfelipeecardozo.votacao_gremio.Service;

import br.com.gustavorochaEfelipeecardozo.votacao_gremio.Repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatoService {
    @Autowired
    private CandidatoRepository candidatoRepository;
}
