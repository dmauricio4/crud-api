package ec.edu.ups.crudapi.controller;


import ec.edu.ups.crudapi.model.Product;
import ec.edu.ups.crudapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product>  getProducts() {
        return  productService.getProducts();
    }

    @PostMapping
    public ResponseEntity<Object> registrarProducto(@RequestBody Product product) {
        return this.productService.newProduct(product);
    }

    @PutMapping
    public ResponseEntity<Object> actualizarProducto(@RequestBody Product product) {

        return this.productService.newProduct(product);
    }

}
