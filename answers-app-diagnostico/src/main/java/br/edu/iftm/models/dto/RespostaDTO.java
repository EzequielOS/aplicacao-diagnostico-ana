package br.edu.iftm.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RespostaDTO {
    private String id;
    private String questionId;
    private String userId;
    private String selectedOption;
    private LocalDateTime answeredAt;
}
