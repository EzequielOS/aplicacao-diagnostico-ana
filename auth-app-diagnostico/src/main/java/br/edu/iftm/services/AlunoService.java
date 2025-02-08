package br.edu.iftm.services;

import br.edu.iftm.models.Aluno;

import java.util.List;

public interface AlunoService {
    Aluno save(Aluno aluno);

    Aluno findById(String id);

    List<Aluno> findAll();

    void deleteById(String id);
}