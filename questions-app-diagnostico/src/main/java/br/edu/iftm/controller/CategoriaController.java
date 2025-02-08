package br.edu.iftm.controller;

import br.edu.iftm.models.Categoria;
import br.edu.iftm.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> findAll() {
        return categoriaService.findAll();
    }

    @PostMapping
    public Categoria create(@RequestBody Categoria categoria) {
        return categoriaService.save(categoria);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable String id) {
        Categoria categoria = categoriaService.findById(id);
        if (categoria != null) {
            return ResponseEntity.ok(categoria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable String id, @RequestBody Categoria categoriaDetails) {
        Categoria categoria = categoriaService.findById(id);
        if (categoria != null) {
            categoria.setNome(categoriaDetails.getNome());
            categoriaService.save(categoria);
            return ResponseEntity.ok(categoria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        categoriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}