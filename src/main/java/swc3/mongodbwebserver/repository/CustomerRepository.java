package swc3.mongodbwebserver.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import swc3.mongodbwebserver.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
