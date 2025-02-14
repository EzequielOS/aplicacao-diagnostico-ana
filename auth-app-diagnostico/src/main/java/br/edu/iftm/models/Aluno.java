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
@Document(collection = "students")
public class Aluno {
    @Id
    private String id;
    @Field("nome_aluno")
    private String name;
    @Field("email_aluno")
    private String email;
    @Field("fb_id_aluno")
    private String firebaseId;
    @Field("turma_aluno")
    private String className;
    @Field("matricula_aluno")
    private String matricula;
    @Field("score_aluno")
    private Integer score;
    @Field("id_responsavel_aluno")
    private String parentId;
    @Field("date_nasc_aluno")
    private String birthDate;

    public static Aluno fromDTO(AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno();
        aluno.setId(alunoDTO.getId());
        aluno.setName(alunoDTO.getNome());
        aluno.setEmail(alunoDTO.getEmail());
        aluno.setFirebaseId(alunoDTO.getFirebaseId());
        aluno.setClassName(alunoDTO.getTurmaId());
        aluno.setMatricula(alunoDTO.getMatricula());
        return aluno;
    }

}