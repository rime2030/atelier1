package ma.emsi.atelier1;

import ma.emsi.atelier1.ENTITIES.produit;
import ma.emsi.atelier1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class Atelier1Application implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    public static void main(String[] args) {
        SpringApplication.run(Atelier1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
           productRepository.save(new produit(null,"computer",4556,3));
           productRepository.save(new produit(null,"smart",4596,4));
           productRepository.save(new produit(null,"tablette",4506,5));
           productRepository.save(new produit(null,"tv",4866,6));
        List<produit> products = productRepository.findAll();
        products.forEach(p -> {
            System.out.println(p.toString());

        });
        produit produit=productRepository.findById(Long.valueOf(1)).get();
        System.out.println(produit.getId());
        System.out.println(produit.getName());
        System.out.println(produit.getQuantity());
        System.out.println("-----------------");
        List<produit> produits = productRepository.findByNameContains("c");
        produits.forEach(p -> {
            System.out.println(p);



        });
        System.out.println("------");
        List<produit> produitss = productRepository.search("%c%");
        produitss.forEach(p -> {
            System.out.println(p);



        });
        System.out.println("-----------------");
        List<produit> Prixproduit = productRepository.findByPriceGreaterThan(3000);
        Prixproduit.forEach(pr -> {
            System.out.println(pr);

        });
        System.out.println("------");
        List<produit> produitPR = productRepository.searchByPrice(3000);
        produitPR.forEach(p -> {
            System.out.println(p);



        });
}
}

