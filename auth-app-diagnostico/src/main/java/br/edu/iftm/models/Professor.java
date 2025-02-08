package br.edu.iftm.models;

import br.edu.iftm.models.dto.ProfessorDTO;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "professores")
public class Professor {
    @Id
    private String id;
    @Field("nome_professor")
    private String nome;
    @Field("email_professor")
    private String email;
    @Field("id_fb_professor")
    private String firebaseId;

    public static Professor fromDTO(ProfessorDTO ProfessorDTO) {
        Professor Professor = new Professor();
        Professor.setId(ProfessorDTO.getId());
        Professor.setNome(ProfessorDTO.getNome());
        Professor.setEmail(ProfessorDTO.getEmail());
        Professor.setFirebaseId(ProfessorDTO.getFirebaseId());
        return Professor;
    }

}