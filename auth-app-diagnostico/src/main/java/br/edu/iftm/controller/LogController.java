package br.edu.iftm.controller;

import br.edu.iftm.models.Log;
import br.edu.iftm.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping
    public List<Log> getAllLogs() {
        return logService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Log> getLogById(@PathVariable String id) {
        Log log = logService.findById(id);
        return log != null ? ResponseEntity.ok(log) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Log createLog(@RequestBody Log log) {
        return logService.save(log);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Log> updateLog(@PathVariable String id, @RequestBody Log logDetails) {
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLog(@PathVariable String id) {
        Log log = logService.findById(id);
        if (log != null) {
            logService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}