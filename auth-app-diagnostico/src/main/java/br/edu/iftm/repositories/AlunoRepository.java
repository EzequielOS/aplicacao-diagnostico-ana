package br.edu.iftm.repositories;

import br.edu.iftm.models.Aluno;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends MongoRepository<Aluno, String> {
    List<Aluno> findByParentId(String parentId);
}