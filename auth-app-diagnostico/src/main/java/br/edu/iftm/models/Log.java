package br.edu.iftm.models;

import br.edu.iftm.models.dto.LogDTO;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "logs")
public class Log {
    @Id
    private String id;
    @Field("id_aluno")
    private String alunoId;
    @Field("action_log")
    private String acao;
    @Field("user_log")
    private String usuario;
    @Field("data")
    private String datetime;

    public static Log fromDTO(LogDTO logDTO) {
        Log log = new Log();
        log.setAlunoId(logDTO.getAlunoId());
        log.setAcao(logDTO.getAcao());
        log.setUsuario(logDTO.getUsuario());
        log.setDatetime(logDTO.getDatetime());
        return log;

    }
}