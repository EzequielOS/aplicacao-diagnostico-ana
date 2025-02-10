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

import br.edu.iftm.models.Responsavel;
import br.edu.iftm.services.ResponsavelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/responsaveis")
@Tag(name = "Responsáveis", description = "Gerenciamento de responsáveis na aplicação")
public class ResponsavelController {

    @Autowired
    private ResponsavelService responsavelService;

    @Operation(summary = "Lista todos os responsáveis", description = "Retorna uma lista com todos os responsáveis registrados")
    @GetMapping
    public List<Responsavel> getAllResponsaveis() {
        return responsavelService.findAll();
    }

    @Operation(summary = "Busca um responsável por ID", description = "Retorna um responsável específico com base no ID informado")
    @GetMapping("/{id}")
    public ResponseEntity<Responsavel> getResponsavelById(
            @Parameter(description = "ID do responsável a ser buscado") @PathVariable String id) {
        Responsavel responsavel = responsavelService.findById(id);
        return responsavel != null ? ResponseEntity.ok(responsavel) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Cria um novo responsável", description = "Adiciona um novo responsável ao sistema")
    @PostMapping
    public Responsavel createResponsavel(@RequestBody Responsavel responsavel) {
        return responsavelService.save(responsavel);
    }

    @Operation(summary = "Atualiza um responsável", description = "Atualiza os dados de um responsável existente com base no ID")
    @PutMapping("/{id}")
    public ResponseEntity<Responsavel> updateResponsavel(
            @Parameter(description = "ID do responsável a ser atualizado") @PathVariable String id,
            @RequestBody Responsavel responsavelDetails) {
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

    @Operation(summary = "Exclui um responsável", description = "Remove um responsável do sistema com base no ID informado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResponsavel(
            @Parameter(description = "ID do responsável a ser deletado") @PathVariable String id) {
        Responsavel responsavel = responsavelService.findById(id);
        if (responsavel != null) {
            responsavelService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}