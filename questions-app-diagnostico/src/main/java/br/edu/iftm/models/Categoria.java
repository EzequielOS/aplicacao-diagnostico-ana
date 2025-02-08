package br.edu.iftm.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "categorias")
public class Categoria {
    @Id
    private String id;
    @Field("nome_categoria")
    private String nome;
}