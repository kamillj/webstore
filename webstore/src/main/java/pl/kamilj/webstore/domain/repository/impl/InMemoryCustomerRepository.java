package pl.kamilj.webstore.domain.repository.impl;

import org.springframework.stereotype.Repository;
import pl.kamilj.webstore.domain.Customer;
import pl.kamilj.webstore.domain.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository{

    private List<Customer> listOfCustomers = new ArrayList<>();

    public InMemoryCustomerRepository(){
        Customer marekMarecki = new Customer("C1", "Marek Marecki", "Pruszków");
        marekMarecki.setNoOfOrdersMade(4);
        Customer edekEdecki = new Customer("C2", "Edek Edecki", "Pruszków");
        edekEdecki.setNoOfOrdersMade(1);
        Customer zdzisławZdzisławski = new Customer("C3", "Zdzisław Zdzisławski", "Warszawa");
        zdzisławZdzisławski.setNoOfOrdersMade(7);

        listOfCustomers.add(marekMarecki);
        listOfCustomers.add(edekEdecki);
        listOfCustomers.add(zdzisławZdzisławski);
    }
    @Override
    public List<Customer> getAllCustomers() {
        return listOfCustomers;
    }
}
