package swc3.mongodbwebserver.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "products")
public class Product {

    @Id
    private String id;
    private String name;
    private int quantity_in_stock;
    private double unit_price;

    public Product(String name, int quantity_in_stock, double unit_price) {
        this.name = name;
        this.quantity_in_stock = quantity_in_stock;
        this.unit_price = unit_price;
    }
}
