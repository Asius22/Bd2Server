package db2server.repository;

import db2server.domain.Product;
import db2server.domain.ProductKey;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface ProductRepository extends MongoRepository<Product, ProductKey> {

    @Query("{'_id.nome': ?0}")
    ArrayList<Product> getProductByName(String nome);

    @Query("{'_id.tipo': ?0}")
    ArrayList<Product> getProductsByType(String tipo);

    @Query("{'_id.tipo':  'PIZZA'}")
    ArrayList<Product> getPizze();

    @Query("{'_id.tipo':   'PANUOZZO'}")
    ArrayList<Product> getPanuozzi();

    @Query("{'_id.tipo':   'BIBITA'}")
    ArrayList<Product> getBibite();

    @Query("{'_id.tipo':   'ANTIPASTO'}")
    ArrayList<Product> getAntipasti();
}
