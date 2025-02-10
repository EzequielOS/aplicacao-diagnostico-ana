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

import br.edu.iftm.models.Aluno;
import br.edu.iftm.services.AlunoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Alunos", description = "Endpoints para gerenciamento de alunos")
@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @Operation(summary = "Listar todos os alunos", description = "Retorna uma lista de todos os alunos cadastrados")
    @GetMapping
    public List<Aluno> getAllAlunos() {
        return alunoService.findAll();
    }

    @Operation(summary = "Buscar aluno por ID", description = "Retorna os detalhes de um aluno específico pelo seu ID")
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getAlunoById(@PathVariable String id) {
        Aluno aluno = alunoService.findById(id);
        return aluno != null ? ResponseEntity.ok(aluno) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Criar um novo aluno", description = "Adiciona um novo aluno ao sistema")
    @PostMapping
    public Aluno createAluno(@RequestBody Aluno aluno) {
        return alunoService.save(aluno);
    }

    @Operation(summary = "Atualizar aluno", description = "Atualiza os dados de um aluno existente")
    @PutMapping("/{id}")
    public ResponseEntity<Aluno> updateAluno(@PathVariable String id, @RequestBody Aluno alunoDetails) {
        Aluno aluno = alunoService.findById(id);
        if (aluno != null) {
            aluno.setNome(alunoDetails.getNome());
            aluno.setEmail(alunoDetails.getEmail());
            alunoService.save(aluno);
            return ResponseEntity.ok(aluno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Deletar aluno", description = "Remove um aluno do sistema pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluno(@PathVariable String id) {
        Aluno aluno = alunoService.findById(id);
        if (aluno != null) {
            alunoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
