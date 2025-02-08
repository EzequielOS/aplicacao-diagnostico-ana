package br.edu.iftm.controller;

import br.edu.iftm.models.Responsavel;
import br.edu.iftm.services.ResponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/responsaveis")
public class ResponsavelController {

    @Autowired
    private ResponsavelService responsavelService;

    @GetMapping
    public List<Responsavel> getAllResponsaveis() {
        return responsavelService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Responsavel> getResponsavelById(@PathVariable String id) {
        Responsavel responsavel = responsavelService.findById(id);
        return responsavel != null ? ResponseEntity.ok(responsavel) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Responsavel createResponsavel(@RequestBody Responsavel responsavel) {
        return responsavelService.save(responsavel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Responsavel> updateResponsavel(@PathVariable String id, @RequestBody Responsavel responsavelDetails) {
        Responsavel responsavel = responsavelService.findById(id);
        if (responsavel != null) {
            responsavel.setNome(responsavelDetails.getNome());
            responsavel.setEmail(responsavelDetails.getEmail());
            responsavelService.save(responsavel);
            return ResponseEntity.ok(responsavel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResponsavel(@PathVariable String id) {
        Responsavel responsavel = responsavelService.findById(id);
        if (responsavel != null) {
            responsavelService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}