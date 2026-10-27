package br.com.gustavorochaEfelipeecardozo.votacao_gremio.Service;

import br.com.gustavorochaEfelipeecardozo.votacao_gremio.Repository.EleitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EleitorService {

    @Autowired
    private EleitorRepository eleitorRepository;
}
