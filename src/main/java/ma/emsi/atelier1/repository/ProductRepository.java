package ma.emsi.atelier1.repository;

import ma.emsi.atelier1.ENTITIES.produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<produit,Long >{
    List<produit> findByNameContains(String mc);
    @Query("select p from produit p where p.name like :x")
    List<produit> search (@Param("x") String mc);
    List<produit> findByPriceGreaterThan(double p);
    @Query("select p from produit p where p.price>:x")
    List<produit> searchByPrice (@Param("x") double pr);
}
