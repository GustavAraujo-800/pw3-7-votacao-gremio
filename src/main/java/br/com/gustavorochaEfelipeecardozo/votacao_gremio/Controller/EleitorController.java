package br.com.gustavorochaEfelipeecardozo.votacao_gremio.Controller;

import br.com.gustavorochaEfelipeecardozo.votacao_gremio.Service.EleitorService;
import br.com.gustavorochaEfelipeecardozo.votacao_gremio.entity.Candidato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidatos")
public class EleitorController {
    @Autowired
    private EleitorService eleitorService;

    @GetMapping
    public Iterable<Candidato> findAll() {}
}
