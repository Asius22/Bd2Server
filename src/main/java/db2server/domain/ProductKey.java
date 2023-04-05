package db2server.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
@Document
public class ProductKey {

    private String nome;
    private Tipo tipo;

    public enum Tipo{
        PIZZA,
        PANUOZZO,
        BIBITA,
        ANTIPASTO
    }
}
