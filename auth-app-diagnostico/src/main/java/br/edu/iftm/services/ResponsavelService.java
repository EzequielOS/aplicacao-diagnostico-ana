package br.edu.iftm.services;

import br.edu.iftm.models.Responsavel;

import java.util.List;

public interface ResponsavelService {
    Responsavel save(Responsavel responsavel);

    Responsavel findById(String id);

    List<Responsavel> findAll();

    void deleteById(String id);
}