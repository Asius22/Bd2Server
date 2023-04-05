package db2server.service;

import db2server.domain.Product;
import db2server.domain.ProductKey;
import db2server.repository.ProductRepository;
import db2server.service.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;

    @Override
    public ArrayList<Product> getAll() {
        return new ArrayList<>(repository.findAll());
    }

    @Override
    public ArrayList<Product> getProductByType(String type) {
        return repository.getProductsByType(type);
    }

    @Override
    public ArrayList<Product> getProductByName(String nome) {
        return repository.getProductByName(nome);
    }

    //meglio usare save, così non ci saranno elementi duplicati
    @Override
    public Product setNewProduct(Product p) {
        return repository.save(p);
    }

    @Override
    public void delete(ProductKey key) {
        repository.deleteById(key);
    }
}
