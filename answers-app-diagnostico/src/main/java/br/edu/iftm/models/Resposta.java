package br.edu.iftm.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
@Document(collection = "respostas")
public class Resposta {
    @Id
    private String id;
    @Field("id_questao")
    private String questionId;
    @Field("id_usuario")
    private String userId;
    @Field("opcao_selecionada")
    private String selectedOption;
    @Field("data_resposta")
    private LocalDateTime answeredAt;
}
