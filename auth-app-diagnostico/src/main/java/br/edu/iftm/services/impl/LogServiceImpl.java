package br.edu.iftm.services.impl;

import br.edu.iftm.models.Log;
import br.edu.iftm.repositories.LogRepository;
import br.edu.iftm.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogRepository logRepository;

    @Override
    public Log save(Log log) {
        return logRepository.save(log);
    }

    @Override
    public Log findById(String id) {
        return logRepository.findById(id).orElse(null);
    }

    @Override
    public List<Log> findAll() {
        return logRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        logRepository.deleteById(id);
    }
}