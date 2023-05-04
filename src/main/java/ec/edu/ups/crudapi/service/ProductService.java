package ec.edu.ups.crudapi.service;

import ec.edu.ups.crudapi.interfaces.ProductRepository;
import ec.edu.ups.crudapi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    HashMap<String, Object> datos;

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
        datos = new HashMap<>();
        //&& Long.valueOf( product.getId()) == null

        if (res.isPresent() && Long.valueOf(product.getId()) == 0) {
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
        datos.put("message", "Guardado con éxito");
         //actualizar
        if (product.getId() != 0){
            datos.put("message", "Actualizado con éxito");
        }

         productRepository.save(product);
         datos.put("datos", product);
         datos.put("message", "Guardado con éxito");
         return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> deleteProduct(Long id){
        datos = new HashMap<>();
        boolean existe = this.productRepository.existsById(id);
        if (!existe){
            datos.put("error", true);
            datos.put("message", "No existe un producto con ese ID");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        productRepository.deleteById(id);
        datos.put("message", "Producto ELIMINADO");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }
}
