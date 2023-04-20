package ec.edu.ups.crudapi.interfaces;

import ec.edu.ups.crudapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    //@Query("Select * from Product p where p.name = ?")
    Optional<Product> findProductByName(String name);
}
