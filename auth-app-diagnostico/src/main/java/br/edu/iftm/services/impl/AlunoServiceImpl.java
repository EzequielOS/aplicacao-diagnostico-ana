package br.edu.iftm.services.impl;

import br.edu.iftm.models.Aluno;
import br.edu.iftm.repositories.AlunoRepository;
import br.edu.iftm.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Override
    public Aluno findById(String id) {
        return alunoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        alunoRepository.deleteById(id);
    }
}