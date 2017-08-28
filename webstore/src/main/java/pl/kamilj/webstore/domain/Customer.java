package pl.kamilj.webstore.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Customer {

    private String customerId;
    private String name;
    private String address;
    private long noOfOrdersMade;

    public Customer(String customerId, String name, String address) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
    }
}
