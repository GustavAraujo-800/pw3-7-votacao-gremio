package br.com.gustavorochaEfelipeecardozo.votacao_gremio.Controller;

import br.com.gustavorochaEfelipeecardozo.votacao_gremio.Service.CandidatoService;
import br.com.gustavorochaEfelipeecardozo.votacao_gremio.entity.Candidato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidatos")
@CrossOrigin(origins = "*")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @GetMapping
    public ResponseEntity<List<Candidato>> listarTodos() {
        return ResponseEntity.ok(candidatoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(candidatoService.buscarPorId(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Candidato> cadastrar(@RequestBody Candidato candidato) {
        return ResponseEntity.status(HttpStatus.CREATED).body(candidatoService.cadastrar(candidato));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Candidato candidato) {
        try {
            return ResponseEntity.ok(candidatoService.atualizar(id, candidato));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        try {
            candidatoService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/{id}/votar")
    public ResponseEntity<?> votar(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(candidatoService.registrarVoto(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
