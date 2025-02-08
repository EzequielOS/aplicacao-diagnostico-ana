package br.edu.iftm.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDTO {
    private String id;
    private String nome;
    private String email;
    private String firebaseId;
    private String turmaId;
    private String matricula;
}
