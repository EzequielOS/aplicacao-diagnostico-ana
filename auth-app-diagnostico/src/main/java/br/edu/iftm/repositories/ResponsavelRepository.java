package br.edu.iftm.repositories;

import br.edu.iftm.models.Responsavel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsavelRepository extends MongoRepository<Responsavel, String> {
}