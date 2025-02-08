package br.edu.iftm.models;

import br.edu.iftm.models.dto.AlunoDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Getter
@Setter
@Document(collection = "alunos")
public class Aluno {
    @Id
    private String id;
    @Field("nome_aluno")
    private String nome;
    @Field("email_aluno")
    private String email;
    @Field("fb_id_aluno")
    private String firebaseId;
    @Field("turma_id_aluno")
    private String turmaId;
    @Field("matricula_aluno")
    private String matricula;

    public static Aluno fromDTO(AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno();
        aluno.setId(alunoDTO.getId());
        aluno.setNome(alunoDTO.getNome());
        aluno.setEmail(alunoDTO.getEmail());
        aluno.setFirebaseId(alunoDTO.getFirebaseId());
        aluno.setTurmaId(alunoDTO.getTurmaId());
        aluno.setMatricula(alunoDTO.getMatricula());
        return aluno;
    }

}