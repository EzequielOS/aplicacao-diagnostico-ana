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

import br.edu.iftm.models.Professor;
import br.edu.iftm.services.ProfessorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/professores")
@Tag(name = "Professores", description = "Gerenciamento de professores na aplicação")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @Operation(summary = "Lista todos os professores", description = "Retorna uma lista com todos os professores registrados")
    @GetMapping
    public List<Professor> getAllProfessores() {
        return professorService.findAll();
    }

    @Operation(summary = "Busca um professor por ID", description = "Retorna um professor específico com base no ID informado")
    @GetMapping("/{id}")
    public ResponseEntity<Professor> getProfessorById(
            @Parameter(description = "ID do professor a ser buscado") @PathVariable String id) {
        Professor professor = professorService.findById(id);
        return professor != null ? ResponseEntity.ok(professor) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Cria um novo professor", description = "Adiciona um novo professor ao sistema")
    @PostMapping
    public Professor createProfessor(@RequestBody Professor professor) {
        return professorService.save(professor);
    }

    @Operation(summary = "Atualiza um professor", description = "Atualiza os dados de um professor existente com base no ID")
    @PutMapping("/{id}")
    public ResponseEntity<Professor> updateProfessor(
            @Parameter(description = "ID do professor a ser atualizado") @PathVariable String id,
            @RequestBody Professor professorDetails) {
        Professor professor = professorService.findById(id);
        if (professor != null) {
            professor.setNome(professorDetails.getNome());
            professor.setEmail(professorDetails.getEmail());
            professorService.save(professor);
            return ResponseEntity.ok(professor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Exclui um professor", description = "Remove um professor do sistema com base no ID informado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfessor(
            @Parameter(description = "ID do professor a ser deletado") @PathVariable String id) {
        Professor professor = professorService.findById(id);
        if (professor != null) {
            professorService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}