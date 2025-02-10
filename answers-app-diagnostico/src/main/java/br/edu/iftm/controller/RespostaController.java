package br.edu.iftm.controller;

import br.edu.iftm.models.Resposta;
import br.edu.iftm.services.RespostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/respostas")
public class RespostaController {

    @Autowired
    private RespostaService respostaService;

    @GetMapping
    public ResponseEntity<List<Resposta>> findAll() {
        List<Resposta> respostas = respostaService.findAll();
        return ResponseEntity.ok(respostas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resposta> findById(@PathVariable String id) {
        Resposta resposta = respostaService.findById(id);
        if (resposta != null) {
            return ResponseEntity.ok(resposta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Resposta> save(@RequestBody Resposta resposta) {
        Resposta savedResposta = respostaService.save(resposta);
        return ResponseEntity.ok(savedResposta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resposta> update(@PathVariable String id, @RequestBody Resposta respostaDetails) {
        Resposta resposta = respostaService.findById(id);
        if (resposta != null) {
            resposta.setAnsweredAt(respostaDetails.getAnsweredAt());
            resposta.setQuestionId(respostaDetails.getQuestionId());
            resposta.setUserId(respostaDetails.getUserId());
            return ResponseEntity.ok(resposta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        respostaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}