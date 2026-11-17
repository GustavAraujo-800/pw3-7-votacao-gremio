package br.com.gustavorochaEfelipeecardozo.votacao_gremio.Controller;

import br.com.gustavorochaEfelipeecardozo.votacao_gremio.Service.EleitorService;
import br.com.gustavorochaEfelipeecardozo.votacao_gremio.entity.Eleitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eleitores")
@CrossOrigin(origins = "*")
public class EleitorController {

    @Autowired
    private EleitorService eleitorService;

    @GetMapping
    public ResponseEntity<List<Eleitor>> listarTodos() {
        return ResponseEntity.ok(eleitorService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(eleitorService.buscarPorId(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Eleitor eleitor) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(eleitorService.cadastrar(eleitor));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Eleitor eleitor) {
        try {
            return ResponseEntity.ok(eleitorService.atualizar(id, eleitor));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        try {
            eleitorService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
