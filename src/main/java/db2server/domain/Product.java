package db2server.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Document

public class Product {

    @Id
    private ProductKey id;
    private String descrizione, image;
    private ArrayList<Double> prezzo;

    public Product(String nome, String tipo, String descrizione, String image, ArrayList<Double> prezzo){
        this.id = new ProductKey(nome, ProductKey.Tipo.valueOf(tipo));
        this.descrizione = descrizione;
        this.image = image;
        this.prezzo = prezzo;
    }

    public String getName(){
        return id.getNome();
    }

    public String getType(){
        return id.getTipo().name();
    }
}
