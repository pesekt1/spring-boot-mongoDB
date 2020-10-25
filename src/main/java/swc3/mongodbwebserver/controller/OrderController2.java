package swc3.mongodbwebserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import swc3.mongodbwebserver.model.Order;
import swc3.mongodbwebserver.model.Product;
import swc3.mongodbwebserver.repository.OrderRepository;
import swc3.mongodbwebserver.repository.ProductRepository;


//this controller takes a product id and queries the whole product from the database ... findById()
//so the json for product only contains id: "product": {"id": ...}

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class OrderController2 {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/orders2")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        try {
            //setting the missing fields in the products
            for (var item: order.getItems()) {
                var productId = item.getProduct().getId();
                Product product = productRepository.findById(productId).get();
                item.getProduct().setName(product.getName());
                item.getProduct().setQuantity_in_stock(product.getQuantity_in_stock());
                item.getProduct().setUnit_price(product.getUnit_price());
            }

            Order orderSaved = orderRepository.save(order);
            return new ResponseEntity<>(orderSaved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
