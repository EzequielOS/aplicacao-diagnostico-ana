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

import br.edu.iftm.models.Log;
import br.edu.iftm.services.LogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/logs")
@Tag(name = "Logs", description = "Gerenciamento de logs da aplicação")
public class LogController {

    @Autowired
    private LogService logService;

    @Operation(summary = "Lista todos os logs", description = "Retorna uma lista com todos os logs registrados")
    @GetMapping
    public List<Log> getAllLogs() {
        return logService.findAll();
    }

    @Operation(summary = "Busca um log por ID", description = "Retorna um log específico com base no ID informado")
    @GetMapping("/{id}")
    public ResponseEntity<Log> getLogById(
            @Parameter(description = "ID do log a ser buscado") @PathVariable String id) {
        Log log = logService.findById(id);
        return log != null ? ResponseEntity.ok(log) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Cria um novo log", description = "Adiciona um novo log ao sistema")
    @PostMapping
    public Log createLog(@RequestBody Log log) {
        return logService.save(log);
    }

    @Operation(summary = "Atualiza um log", description = "Atualiza os dados de um log existente com base no ID")
    @PutMapping("/{id}")
    public ResponseEntity<Log> updateLog(
            @Parameter(description = "ID do log a ser atualizado") @PathVariable String id,
            @RequestBody Log logDetails) {
        Log log = logService.findById(id);
        if (log != null) {
            log.setAlunoId(logDetails.getAlunoId());
            log.setAcao(logDetails.getAcao());
            log.setUsuario(logDetails.getUsuario());
            log.setDatetime(logDetails.getDatetime());
            logService.save(log);
            return ResponseEntity.ok(log);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Exclui um log", description = "Remove um log do sistema com base no ID informado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLog(
            @Parameter(description = "ID do log a ser deletado") @PathVariable String id) {
        Log log = logService.findById(id);
        if (log != null) {
            logService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}