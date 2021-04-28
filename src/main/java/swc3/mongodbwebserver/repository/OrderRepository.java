package swc3.mongodbwebserver.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import swc3.mongodbwebserver.model.Order;

public interface OrderRepository extends MongoRepository<Order, String> {

}
