package br.edu.iftm.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestaoDTO {
    private String id;
    private String category;
    private String level;
    private String title;
    private String description;
    private List<String> options;
    private String correctAnswer;
    private int value;
}