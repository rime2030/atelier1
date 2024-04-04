package ma.emsi.atelier1.web;

import ma.emsi.atelier1.ENTITIES.produit;
import ma.emsi.atelier1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class produitRestService {
    @Autowired
    private ProductRepository productRepository;
   @GetMapping ("/produits")
    public List<produit> produits (){
        return productRepository.findAll();
    }
}
