package swc3.mongodbwebserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import swc3.mongodbwebserver.model.Order;
import swc3.mongodbwebserver.repository.CustomerRepository;
import swc3.mongodbwebserver.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

//this controller expect all the info structure of the order document - example:
//{
//        "orderDate":"1986-03-28",
//        "comments":"comment1",
//        "shippedDate":"1986-04-28",
//        "customerId":"5f9542c9adefcf6c98bafdbd",
//        "orderStatus":"shipped",
//        "shipperName":"shipper1",
//        "items": [
//            {
//                "id": 1,
//                "quantity": 2,
//                "note": "note1",
//                "product":
//                {
//                    "id": "5f954230adefcf6c98bafdb3",
//                    "name": "product1",
//                    "quantityInStock": 5,
//                    "unitPrice": 1.1
//                }
//            },
//            {
//                "id": 2,
//                "quantity": 3,
//                "note": "note1",
//                "product":
//                {
//                    "id": "5f954230adefcf6c98bafdbc",
//                    "name": "product3",
//                    "quantityInStock": 3,
//                    "unitPrice": 1.2
//                }
//            }
//        ]
//}

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders() {
        try {
            List<Order> orders = new ArrayList<Order>();
            orders.addAll(orderRepository.findAll());

            if (orders.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/orders")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        try {
            //Customer customer = customerRepository.findById(order.getCustomerId()).orElseThrow();

            Order orderSaved = orderRepository.save(order);
            return new ResponseEntity<>(orderSaved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
