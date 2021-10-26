package swc3.mongodbwebserver.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderItem{
    private int id;
    private int quantity;
    //private Collection<String> notes;
    private String note;
    private Product product;

    public OrderItem(int quantity, String note, int id, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.note = note;
        this.product = product;
    }
}