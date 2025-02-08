package br.edu.iftm.models;

import br.edu.iftm.models.dto.ResponsavelDTO;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "responsaveis")
public class Responsavel {
    @Id
    private String id;
    @Field("nome_resp")
    private String nome;
    @Field("email_resp")
    private String email;
    @Field("id_fb_resp")
    private String firebaseId;

    public static Responsavel fromDTO(ResponsavelDTO responsavelDTO) {
        Responsavel responsavel = new Responsavel();
        responsavel.setId(responsavelDTO.getId());
        responsavel.setNome(responsavelDTO.getNome());
        responsavel.setEmail(responsavelDTO.getEmail());
        responsavel.setFirebaseId(responsavelDTO.getFirebaseId());
        return responsavel;
    }
}