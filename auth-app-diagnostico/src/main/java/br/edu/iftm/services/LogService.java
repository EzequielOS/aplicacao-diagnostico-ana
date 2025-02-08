package br.edu.iftm.services;

import br.edu.iftm.models.Log;

import java.util.List;

public interface LogService {
    Log save(Log log);

    Log findById(String id);

    List<Log> findAll();

    void deleteById(String id);
}