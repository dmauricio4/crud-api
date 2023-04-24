package ec.edu.ups.crudapi.service;

import ec.edu.ups.crudapi.interfaces.ProductRepository;
import ec.edu.ups.crudapi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;


    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return this.productRepository.findAll();
    }

    public ResponseEntity<Object> newProduct(Product product) {
         Optional<Product> res = productRepository.findProductByName(product.getName());

        HashMap<String, Object> datos = new HashMap<>();

         if (res.isPresent()){
             datos.put("error", true);
             datos.put("message", "Ya existe un producto con ese nombre");
             //Esta respuesta es solo para probar con postman
             //throw new IllegalStateException("Ya existe el producto");

             //Respuesta mejororada, cuando se quiere crear un producto con el mismo nombre
             return new ResponseEntity<>(
                     datos,
                     HttpStatus.CONFLICT
             );
         }
         productRepository.save(product);
         datos.put("datos", product);
         datos.put("message", "Guardado con éxito");
         return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }
}
