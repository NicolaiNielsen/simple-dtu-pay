package SimpleDTUPay.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import SimpleDTUPay.PersonRegistry;
import SimpleDTUPay.model.Customer;
import SimpleDTUPay.model.Person;

public class CustomerService {

    public CustomerService() {
    }

    public String createCustomer(Customer customer) {
        Customer newCustomer = new Customer();
        newCustomer.setName(customer.getName());
        newCustomer.setId();
        String id = newCustomer.getId();
        PersonRegistry.persons.put(id, newCustomer);
        return id;
    }

    public java.util.Collection<Customer> findAll() {
        Collection<Customer> customers = new java.util.ArrayList<>();

        for (Person person : PersonRegistry.persons.values()) {
            if (person instanceof Customer) {
                customers.add((Customer) person);
            }
        }
        return customers;
    }
    
    public Optional<Customer> getCustomerById(String id) {
        System.out.println("Searching for customer with id " + id + " in  person registry");
        Person person = PersonRegistry.persons.get(id);
        if (person instanceof Customer) {
            return Optional.of((Customer) person);
        }
        return Optional.empty();
    }
}
