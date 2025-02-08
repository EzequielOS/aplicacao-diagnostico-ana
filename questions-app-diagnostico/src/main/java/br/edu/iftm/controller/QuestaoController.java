package br.edu.iftm.controller;

import br.edu.iftm.models.Questao;
import br.edu.iftm.services.QuestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questoes")
public class QuestaoController {

    @Autowired
    private QuestaoService questaoService;

    @GetMapping
    public List<Questao> findAll() {
        return questaoService.findAll();
    }

    @PostMapping
    public Questao create(@RequestBody Questao questao) {
        return questaoService.save(questao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Questao> findById(@PathVariable String id) {
        Questao questao = questaoService.findById(id);
        if (questao != null) {
            return ResponseEntity.ok(questao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Questao> update(@PathVariable String id, @RequestBody Questao questaoDetails) {
        Questao questao = questaoService.findById(id);
        if (questao != null) {
            questao.setCategory(questaoDetails.getCategory());
            questao.setLevel(questaoDetails.getLevel());
            questao.setTitle(questaoDetails.getTitle());
            questao.setDescription(questaoDetails.getDescription());
            questao.setOptions(questaoDetails.getOptions());
            questao.setCorrectAnswer(questaoDetails.getCorrectAnswer());
            questao.setValue(questaoDetails.getValue());
            questaoService.save(questao);
            return ResponseEntity.ok(questao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        questaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}