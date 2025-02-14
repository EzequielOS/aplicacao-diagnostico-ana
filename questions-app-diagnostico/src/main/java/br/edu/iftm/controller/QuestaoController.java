package br.edu.iftm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.models.Questao;
import br.edu.iftm.services.QuestaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/questions")
@Tag(name = "Questões", description = "Gerenciamento de questões")
public class QuestaoController {

    @Autowired
    private QuestaoService questaoService;

    @Operation(summary = "Lista todas as questões", description = "Retorna uma lista com todas as questões cadastradas")
    @GetMapping
    public List<Questao> findAll() {
        return questaoService.findAll();
    }

    @Operation(summary = "Cria uma nova questão", description = "Adiciona uma nova questão ao sistema")
    @PostMapping
    public Questao create(@RequestBody Questao questao) {
        return questaoService.save(questao);
    }

    @Operation(summary = "Busca uma questão por ID", description = "Retorna uma questão específica com base no ID informado")
    @GetMapping("id/{id}")
    public ResponseEntity<Questao> findById(
            @Parameter(description = "ID da questão a ser buscada") @PathVariable String id) {
        Questao questao = questaoService.findById(id);
        if (questao != null) {
            return ResponseEntity.ok(questao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Atualiza uma questão", description = "Atualiza os dados de uma questão existente com base no ID")
    @PutMapping("/{id}")
    public ResponseEntity<Questao> update(
            @Parameter(description = "ID da questão a ser atualizada") @PathVariable String id,
            @RequestBody Questao questaoDetails) {
        Questao questao = questaoService.findById(id);
        if (questao != null) {
            questao.setCategory(questaoDetails.getCategory());
            questao.setLevel(questaoDetails.getLevel());
            questao.setTitle(questaoDetails.getTitle());
            questao.setText(questaoDetails.getText());
            questao.setOptions(questaoDetails.getOptions());
            questao.setCorrectOption(questaoDetails.getCorrectOption());
            questao.setValue(questaoDetails.getValue());
            questaoService.save(questao);
            return ResponseEntity.ok(questao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Exclui uma questão", description = "Remove uma questão do sistema com base no ID informado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(
            @Parameter(description = "ID da questão a ser deletada") @PathVariable String id) {
        questaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{classLevel}")
    public ResponseEntity<List<Questao>> getQuestionsByClassLevel(@PathVariable String classLevel) {
        List<Questao> questions = questaoService.getQuestionsByClassLevel(classLevel);
        return ResponseEntity.ok(questions);
    }

    @PostMapping("/add")
    public ResponseEntity<Questao> addQuestion(@RequestBody Questao question) {
        Questao savedQuestion = questaoService.addQuestion(question);
        return ResponseEntity.ok(savedQuestion);
    }
}