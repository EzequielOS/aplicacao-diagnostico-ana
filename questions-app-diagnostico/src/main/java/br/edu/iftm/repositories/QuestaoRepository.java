package br.edu.iftm.repositories;

import br.edu.iftm.models.Questao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestaoRepository extends MongoRepository<Questao, String> {
}
