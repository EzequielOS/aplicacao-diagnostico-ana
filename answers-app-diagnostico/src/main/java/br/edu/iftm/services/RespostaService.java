package br.edu.iftm.services;

import br.edu.iftm.models.Resposta;

import java.util.List;

public interface RespostaService {
    List<Resposta> findAll();

    Resposta findById(String id);

    Resposta save(Resposta resposta);

    void deleteById(String id);
}