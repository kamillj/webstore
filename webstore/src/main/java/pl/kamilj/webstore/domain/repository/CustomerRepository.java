package pl.kamilj.webstore.domain.repository;


import pl.kamilj.webstore.domain.Customer;

import java.util.List;

public interface CustomerRepository {

    List<Customer> getAllCustomers();
}
