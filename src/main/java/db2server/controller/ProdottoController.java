package db2server.controller;

import db2server.domain.Product;
import db2server.domain.ProductKey;
import db2server.service.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("prodotti")
public class ProdottoController {
    @Autowired
    private ProductService service;
    /*
       *sezione generale
     */
    @GetMapping(path = "/")
    public ResponseEntity<List<Product>> getAll() {
        return okList(service.getAll());
    }

    @PostMapping(path = "/")
    public ResponseEntity<Product> setNewProduct(@RequestBody Product p) {
        return ok(service.setNewProduct(p));
    }

    @GetMapping(path = "/f")
    public ResponseEntity<List<Product>> getByName(@RequestParam(name = "nome") String nome){
        List<Product> p = service.getProductByName(nome);
        return p == null ? new ResponseEntity<>(null, HttpStatusCode.valueOf(404)) : okList(p);
    }

    @DeleteMapping(path = "/d")
    public ResponseEntity<Product> deleteProduct(@RequestParam(name = "nome") String nome){
        ProductKey key = service.getProductByName(nome).get(0).getId();
        service.delete(key);
        return ok(null);
    }
    /*
    SEZIONE PIZZE   /pizze
     */
    @GetMapping(path = "/pizze")
    public ResponseEntity<List<Product>> getPizze(){

        return okList(
                removeNullValues(
                        service.getProductByType(ProductKey.Tipo.PIZZA.name())
                )
        );
    }
    /*
    SEZIONE BIBITE
     */
    @GetMapping(path = "/bibite")
    public ResponseEntity<List<Product>> getBibite(){
        return okList(
                removeNullValues(
                        service.getProductByType(ProductKey.Tipo.BIBITA.name())
                )
        );
    }
    /*
    SEZIONE PANUOZZO
     */
    @GetMapping(path = "/panuozzi")
    public ResponseEntity<List<Product>> getPanuozzi(){
        return okList(
                removeNullValues(
                        service.getProductByType(ProductKey.Tipo.PANUOZZO.name())
                )
        );
    }
    /*
    SEZIONE ANTIPASTI
     */
    @GetMapping(path = "/antipasti")
    public ResponseEntity<List<Product>> getAntipasti(){
        return okList(
                removeNullValues(
                        service.getProductByType(ProductKey.Tipo.ANTIPASTO.name())
                )
        );
    }
    /*
    METODI PRIVATI
     */

    private List<Product> removeNullValues(List<Product> list){
        for (Product p: list){
            if (p.getDescrizione() == null)
                p.setDescrizione("");
            if (p.getImage() == null)
                p.setImage("");

        }
        return list;
    }
    /**
     * metodo per restituire una response positiva per una lista di prodotti
     * @param p lista di prodotti da restituire al client
     * @return
     */
    private static ResponseEntity<List<Product>> okList(List<Product> p) {
        return ResponseEntity.ok(p);
    }
    /**
     * metodo per restituire una response positiva per un prodotto
     * @param p prodotto da restituire al client
     * @return
     */
    private static ResponseEntity<Product> ok(Product p) {
        return ResponseEntity.ok(p);
    }
}
