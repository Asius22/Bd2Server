package db2server.service.api;

import db2server.domain.Product;
import db2server.domain.ProductKey;

import java.util.ArrayList;
import java.util.List;

public interface ProductService {
    ArrayList<Product> getAll();
    ArrayList<Product> getProductByType(String type);
    ArrayList<Product> getProductByName(String nome);
    Product setNewProduct(Product p);
    void delete(ProductKey key);


}
