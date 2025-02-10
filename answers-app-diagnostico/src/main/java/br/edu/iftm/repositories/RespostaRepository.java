package br.edu.iftm.repositories;

import br.edu.iftm.models.Resposta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespostaRepository extends MongoRepository<Resposta, String> {
}
