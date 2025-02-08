package br.edu.iftm.services.impl;

import br.edu.iftm.models.Questao;
import br.edu.iftm.repositories.QuestaoRepository;
import br.edu.iftm.services.QuestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestaoServiceImpl implements QuestaoService {
    @Autowired
    private QuestaoRepository questaoRepository;

    @Override
    public Questao save(Questao questao) {
        return questaoRepository.save(questao);
    }

    @Override
    public Questao findById(String id) {
        return questaoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Questao> findAll() {
        return questaoRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        questaoRepository.deleteById(id);
    }


}
