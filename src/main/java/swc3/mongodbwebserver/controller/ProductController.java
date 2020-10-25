package swc3.mongodbwebserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import swc3.mongodbwebserver.model.Product;
import swc3.mongodbwebserver.repository.ProductRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        try {
            //Product productNew = new Product(product.getName(),product.getQuantityInStock(),product.getUnitPrice());
            Product productNew = new Product(product.getName(),product.getQuantity_in_stock(),product.getUnit_price());
            Product productSaved = productRepository.save(productNew);
            return new ResponseEntity<>(productSaved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
