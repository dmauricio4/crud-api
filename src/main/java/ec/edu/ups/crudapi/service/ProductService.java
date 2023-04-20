package ec.edu.ups.crudapi.service;

import ec.edu.ups.crudapi.model.Product;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class ProductService {

    public List<Product> getProducts() {
        return List.of(
                new Product(
                        221515L,
                        "Fanta",
                        200,
                        LocalDate.of(2023, Month.JANUARY, 28),
                        2));
    }
}
