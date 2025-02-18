package br.edu.iftm.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document(collection = "questoes")
public class Questao {
    @Id
    private String id;
    @Field("quest_categoria")
    private String category;
    @Field("quest_level")
    private String level;
    @Field("quest_title")
    private String title;
    @Field("quest_description")
    private String text;
    @Field("quest_options")
    private List<String> options;
    @Field("quest_correct_option")
    private String correctOption;
    @Field("quest_value")
    private int value;
    private String imageUrl; // URL da imagem armazenada (ex: Firebase Storage, S3, etc.)
    private String classLevel; // Exemplo: "1º Ano", "2º Ano"
}