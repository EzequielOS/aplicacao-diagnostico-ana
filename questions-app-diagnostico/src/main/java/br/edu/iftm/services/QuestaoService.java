package br.edu.iftm.services;

import br.edu.iftm.models.Questao;

import java.util.List;

public interface QuestaoService {
    Questao save(Questao questao);

    Questao findById(String id);

    List<Questao> findAll();

    void deleteById(String id);

    Questao addQuestion(Questao question);

    List<Questao> getQuestionsByClassLevel(String classLevel);
}
