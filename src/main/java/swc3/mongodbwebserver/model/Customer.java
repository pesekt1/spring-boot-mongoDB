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
@Document(collection = "customers")
public class Customer {

    @Id
    private String id;
    private String first_name;
    private String last_name;
    private Date birth_date;
    private String phone;
    private String address;
    private String city;
    private String state;
    private int points;

    public Customer(String firstName, String lastName, Date birthDate, String phone, String address, String city, String state, int points) {
        this.first_name = firstName;
        this.last_name = lastName;
        this.birth_date = birthDate;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.points = points;
    }

}
