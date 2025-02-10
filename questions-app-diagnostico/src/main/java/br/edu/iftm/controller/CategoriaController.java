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

import br.edu.iftm.models.Categoria;
import br.edu.iftm.services.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/categorias")
@Tag(name = "Categorias", description = "Gerenciamento de categorias das questões")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Operation(summary = "Lista todas as categorias", description = "Retorna uma lista com todas as categorias cadastradas")
    @GetMapping
    public List<Categoria> findAll() {
        return categoriaService.findAll();
    }

    @Operation(summary = "Cria uma nova categoria", description = "Adiciona uma nova categoria ao sistema")
    @PostMapping
    public Categoria create(@RequestBody Categoria categoria) {
        return categoriaService.save(categoria);
    }

    @Operation(summary = "Busca uma categoria por ID", description = "Retorna uma categoria específica com base no ID informado")
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(
            @Parameter(description = "ID da categoria a ser buscada") @PathVariable String id) {
        Categoria categoria = categoriaService.findById(id);
        if (categoria != null) {
            return ResponseEntity.ok(categoria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Atualiza uma categoria", description = "Atualiza os dados de uma categoria existente com base no ID")
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(
            @Parameter(description = "ID da categoria a ser atualizada") @PathVariable String id,
            @RequestBody Categoria categoriaDetails) {
        Categoria categoria = categoriaService.findById(id);
        if (categoria != null) {
            categoria.setNome(categoriaDetails.getNome());
            categoriaService.save(categoria);
            return ResponseEntity.ok(categoria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Exclui uma categoria", description = "Remove uma categoria do sistema com base no ID informado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(
            @Parameter(description = "ID da categoria a ser deletada") @PathVariable String id) {
        categoriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}