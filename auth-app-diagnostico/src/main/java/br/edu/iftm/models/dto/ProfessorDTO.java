package br.edu.iftm.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "professores")
public class ProfessorDTO {
    private String id;
    private String nome;
    private String email;
    private String firebaseId;
}