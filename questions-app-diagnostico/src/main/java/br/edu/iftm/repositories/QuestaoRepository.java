package br.edu.iftm.repositories;

import br.edu.iftm.models.Questao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestaoRepository extends MongoRepository<Questao, String> {
    List<Questao> findByClassLevel(String classLevel);
}
