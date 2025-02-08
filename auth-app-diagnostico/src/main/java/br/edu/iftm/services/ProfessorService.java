package br.edu.iftm.services;

import br.edu.iftm.models.Professor;

import java.util.List;

public interface ProfessorService {
    Professor save(Professor professor);

    Professor findById(String id);

    List<Professor> findAll();

    void deleteById(String id);
}