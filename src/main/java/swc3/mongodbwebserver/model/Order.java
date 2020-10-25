package swc3.mongodbwebserver.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;

@Getter
@Setter
@ToString
@Document(collection = "orders")
public class Order {

    @Id
    private String id;
    private Date orderDate;
    private String comments;
    private Date shippedDate;
    private String customerId;
    private String orderStatus;
    private String shipperName;
    private OrderItem[] items;

    public Order(Date orderDate, String comments, Date shippedDate, String customerId, String orderStatus, String shipperName, OrderItem[] items) {
        this.orderDate = orderDate;
        this.comments = comments;
        this.shippedDate = shippedDate;
        this.customerId = customerId;
        this.orderStatus = orderStatus;
        this.shipperName = shipperName;
        this.items = items;
    }

}


