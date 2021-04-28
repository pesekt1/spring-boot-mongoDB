package swc3.mongodbwebserver.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Getter
@Setter
@ToString
@Document(collection = "customers")
public class Customer {

    @Id
    private String id;
    private String first_name;
    private String last_name;
    private String birth_date;
    private String phone;
    private String address;
    private String city;
    private String state;
    private int points;
}
