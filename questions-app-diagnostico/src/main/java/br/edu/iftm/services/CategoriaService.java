package br.edu.iftm.services;

import br.edu.iftm.models.Categoria;

import java.util.List;

public interface CategoriaService {
    Categoria save(Categoria categoria);

    Categoria findById(String id);

    List<Categoria> findAll();

    void deleteById(String id);
}
