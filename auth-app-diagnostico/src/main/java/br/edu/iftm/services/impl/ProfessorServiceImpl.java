package br.edu.iftm.services.impl;

import br.edu.iftm.models.Professor;
import br.edu.iftm.repositories.ProfessorRepository;
import br.edu.iftm.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public Professor findById(String id) {
        return professorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        professorRepository.deleteById(id);
    }
}