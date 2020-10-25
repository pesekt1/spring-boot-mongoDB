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
//    private int quantityInStock;
//    private double unitPrice;
    private int quantity_in_stock;
    private double unit_price;

    public Product(String name, int quantityInStock, double unitPrice) {
        this.name = name;
//        this.quantityInStock = quantityInStock;
//        this.unitPrice = unitPrice;
        this.quantity_in_stock = quantityInStock;
        this.unit_price = unitPrice;
    }

    public Product(){};
}
